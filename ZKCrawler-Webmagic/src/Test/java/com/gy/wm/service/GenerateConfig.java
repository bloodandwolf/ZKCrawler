package com.gy.wm.service;

import com.alibaba.fastjson.JSON;
import com.gy.wm.dao.ParserDao;
import com.gy.wm.plugins.newsExportPlugin.parse.HtmlField;
import com.gy.wm.plugins.newsExportPlugin.parse.ParserConfig;
import com.gy.wm.plugins.newsExportPlugin.parse.ParserEntity;
import com.gy.wm.plugins.newsExportPlugin.parse.UrlPattern;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/10/24.
 */
public class GenerateConfig {

    @Test
    public void testConfig() {
        List<UrlPattern> urlPatterns = new ArrayList<>();
        List<HtmlField> fileds = new ArrayList<>();
        urlPatterns.add(new UrlPattern("http://www.qxn.gov.cn/List(OrgDT|Art)/\\w+/\\d+.html", "COLUMN_REGEX"));

        urlPatterns.add(new UrlPattern("http://www.qxn.gov.cn/View/(\\w|.)+/\\d+.html", "CONTENT_LINK_REGEX"));

        HtmlField title = new HtmlField();
        title.setFieldName("title");
        List<String> list1 = new ArrayList<>();
        list1.add("//div[@class='title']/h1");
        title.setXpaths(list1);


        HtmlField content = new HtmlField();
        content.setFieldName("content");
        List<String> list2 = new ArrayList<>();
        list2.add("//div[@id='IDNewsDtail']/font");

      /*  List<String> exPaths=new ArrayList<>();
        exPaths.add("//div[@id='embed_hzh_div']");
        content.setExcludeXpaths(exPaths);*/

        content.setXpaths(list2);

       HtmlField sourceName = new HtmlField();
        List<String> list4 = new ArrayList<>();
        list4.add("");

        sourceName.setXpaths(list4);
        sourceName.setFieldName("sourceName");


        HtmlField author = new HtmlField();
        List<String> list5 = new ArrayList<>();
        list5.add("");
        author.setFieldName("author");

        HtmlField inforBar = new HtmlField();
        List<String> list6 = new ArrayList<>();
        list6.add("//div[@class='title']/span");
        inforBar.setFieldName("infoBar");
        inforBar.setXpaths(list6);

        HtmlField pulishTime = new HtmlField();
        pulishTime.setFieldName("publishTime");
        List<String> puList = new ArrayList<>();
        puList.add("");
        pulishTime.setXpaths(puList);


        author.setXpaths(list5);

        fileds.add(title);
        fileds.add(content);
        /*fileds.add(sourceName);
        fileds.add(author);*/
        fileds.add(inforBar);
     //   fileds.add(pulishTime);

        ParserConfig config = new ParserConfig();
        config.setFields(fileds);
        config.setTaskId("1cd0885cae7d8efe5a5fdf76e2e157eb");
        config.setUrlPatterns(urlPatterns);
        String s = JSON.toJSONString(config);
        System.out.printf(s);
        ParserDao dao = new ParserDao();
        com.gy.wm.plugins.newsExportPlugin.parse.ParserEntity entity = new ParserEntity();
        entity.setConfig(s);
        entity.setTid("1cd0885cae7d8efe5a5fdf76e2e157eb");
        dao.insert(entity);

    }
    @Test
    public void testUrlMatch(){
        String url="http://www.gaxq.gov.cn/\\w+/\\w+/index.shtml";
        Pattern pattern = Pattern.compile(url);
      Matcher matcher = pattern.matcher("http://www.gaxq.gov.cn/xwdt/gayw/20823.shtml");
        System.out.println(matcher.find());
    }
    @Test
    public void testRegex(){
        String urlre="http://(politics|world|news|mil).gmw.cn/node_\\d+";
        String url = "http://politics.gmw.cn/node_9844.htm";
        System.out.println(url.matches(urlre));
    }
}