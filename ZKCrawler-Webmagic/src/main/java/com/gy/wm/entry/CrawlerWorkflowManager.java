package com.gy.wm.entry;

import com.gy.wm.dbpipeline.impl.CMSHbasePipeline;
import com.gy.wm.dbpipeline.impl.HDFSPipeline;
import com.gy.wm.dbpipeline.impl.MysqlPipeline;
import com.gy.wm.model.CrawlData;
import com.gy.wm.queue.RedisCrawledQue;
import com.gy.wm.queue.RedisToCrawlQue;
import com.gy.wm.schedular.RedisScheduler;
import com.gy.wm.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import us.codecraft.webmagic.Spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 */
public class CrawlerWorkflowManager {
    private static final Logger LOG= LoggerFactory.getLogger(CrawlerWorkflowManager.class);
    //待爬取队列
    private RedisToCrawlQue nextQueue = InstanceFactory.getRedisToCrawlQue();
    //已爬取队列
    private RedisCrawledQue crawledQueue = InstanceFactory.getRedisCrawledQue();

    private String tid;

    private String appname;

    private String domain;

    public CrawlerWorkflowManager(String tid, String appname) {
        this.tid = tid;
        this.appname = appname;
    }

    public void crawl(List<CrawlData> seeds, String tid, String starttime, int pass) throws IOException {

        JedisPoolUtils jedisPoolUtils = new JedisPoolUtils();
        JedisPool pool = jedisPoolUtils.getJedisPool();
        Jedis jedis = pool.getResource();
        domain = GetDomain.getDomain(seeds.get(0).getUrl());

        LOG.info("****************************==>> task started, domain:  " + domain + ", taskId: " + tid);
        try {
            nextQueue.putNextUrls(seeds, jedis, tid);
        } finally {
            pool.returnResource(jedis);
        }

        //初始化布隆过滤HASH表
        BloomFilter bloomFilter = new BloomFilter(jedis, 1000, 0.001f, (int) Math.pow(2, 31));
        for (CrawlData seed : seeds) {
            bloomFilter.add("redis:bloomfilter:" + tid, seed.getUrl());
        }
        //初始化webMagic的Spider程序
        initSpider(seeds, domain);
    }

    protected void initSpider(List<CrawlData> seeds, String domain) {
        List<String> seedList = new ArrayList<>();
        for (CrawlData crawlData : seeds) {
            seedList.add(crawlData.getUrl());
        }
        String[] urlArray = seedList.toArray(new String[seedList.size()]);

        //Spider抓取类初始化设置
        Spider spider = null;
        try {
            //反射机制取得下载插件，PluginUtil为反射工具类
            spider = new PluginUtil().excutePluginDownload(tid,domain);
        } catch (Exception e) {
            e.printStackTrace();
        }

        spider.setScheduler(new RedisScheduler(domain)).setUUID(tid)
                //从seed开始抓

                .addUrl(urlArray)
                .addPipeline(
                        new MysqlPipeline())
//                        new HDFSPipeline("/user/root/icp"))
//                .addPipeline(new EsPipeline())
//                .addPipeline(new HbaseEsPipeline())
//                .addPipeline(new HbasePipeline())
//                .addPipeline(new CMSHbasePipeline())
                        //开启5个线程抓取
                .thread(10)
                        //启动爬虫
                .run();
    }
}
