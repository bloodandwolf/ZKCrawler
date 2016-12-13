package com.gy.wm.htmlextract; /**
 * @author Xin Chen
 * Created on 2009-11-11
 * Updated on 2010-08-09
 * Email:  xchen@ir.hit.edu.cn
 * Blog:   http://hi.baidu.com/爱心同盟_陈鑫
 */
import com.gy.wm.downloader.HttpClientDownloader;
import com.gy.wm.util.HttpUtil;
import com.gy.wm.util.HttpUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.http.client.methods.HttpGet;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * TextExtractor功能测试类.
 */

public class UserDemo {

    public static void main(String[] args) throws IOException {

		/*
		 * 测试网站：
		 * 百度博客空间             http://hi.baidu.com/liyanhong/
		 * 新浪娱乐音乐新闻与信息	http://ent.sina.com.cn/music/roll.html
		 * 腾讯娱乐新闻与信息		http://ent.qq.com/m_news/mnews.htm
		 * 搜狐音乐新闻				http://music.sohu.com/news.shtml
		 * 哈尔滨工业大学校内信息网 http://today.hit.edu.cn/
		 * 哈尔滨工业大学校内新闻网 http://news.hit.edu.cn/
		 */


		/* 注意：本处只为展示抽取效果，不处理网页编码问题，getHTML只能接收GBK编码的网页，否则会出现乱码 */
        String content = getHTML("http://ent.163.com/16/1118/07/C64UGQMJ000380BQ.html#f=post1603_tab_news");

        // http://ent.sina.com.cn/y/2010-04-18/08332932833.shtml
        // http://ent.qq.com/a/20100416/000208.htm
        // http://ent.sina.com.cn/y/2010-04-18/15432932937.shtml
        // http://ent.qq.com/a/20100417/000119.htm
        // http://news.hit.edu.cn/articles/2010/04-12/04093006.htm


		/*
		 * 当待抽取的网页正文中遇到成块的新闻标题未剔除时，只要增大此阈值即可。
		 * 相反，当需要抽取的正文内容长度较短，比如只有一句话的新闻，则减小此阈值即可。
		 * 阈值增大，准确率提升，召回率下降；值变小，噪声会大，但可以保证抽到只有一句话的正文
		 */
        //TextExtract.setThreshold(76); // 默认值86

        System.out.println("got html");
        System.out.println(TextExtract.parse(content));
    }


    public static String getHTML(String strURL) throws IOException {
        HttpClientDownloader downloader = new HttpClientDownloader();
        Request request = new Request();
        request.setUrl(strURL);
       Page p = downloader.download(request,null);
      String s =  p.getRawText();
         return s;
    }
}
