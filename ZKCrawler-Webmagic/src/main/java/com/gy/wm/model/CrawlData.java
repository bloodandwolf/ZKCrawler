package com.gy.wm.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/29.
 */
public class CrawlData implements Serializable {

    private String docId = "";

    private String textPTag = "";
    private JSONArray tags;
    private JSONArray categories;


    private String tid;
    private String url;
    private int statusCode;
    private int pass;//遍数;
    private String type;
    private String rootUrl;
    private String fromUrl;
    private String text;
    private String html;
    private String title;
    private String startTime;
    private Date crawlTime;
    private String publishTime;
    private long depthfromSeed;//层数
    private long count;
    private String tag;//爬虫带的原始标签，比如地域area
    private boolean fetched;
    private String author;
    private String sourceName;
    private String parsedData;


    private Map<String, Object> crawlerdata = new HashMap<>();

    public String getParsedData() {
        return parsedData;
    }

    public void setParsedData(String parsedData) {
        this.parsedData = parsedData;
    }

    public Map<String, Object> getCrawlerdata() {
        return crawlerdata;
    }

    public void setCrawlerdata(Map<String, Object> crawlerdata) {
        if (crawlerdata != null) {
            this.crawlerdata = crawlerdata;
            this.parsedData = JSON.toJSONString(crawlerdata);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    private List<Map<String, String>> fieldsMap;

    public List<Map<String, String>> getFieldsMap() {
        return fieldsMap;
    }

    public void setFieldsMap(List<Map<String, String>> fieldsMap) {
        this.fieldsMap = fieldsMap;
    }

    public CrawlData() {
        this.tags = new JSONArray();
        this.categories = new JSONArray();
    }

    public CrawlData(String url, int statusCode, int pass, String type, String rootUrl, String fromUrl, String text, String html, String title,

                     String startTime, Date crawlTime, String publishTime, long depthfromSeed, String tag, long count, boolean fetched, String author, String sourceName) {
        this.tags = new JSONArray();
        this.categories = new JSONArray();

        this.url = url;
        this.statusCode = statusCode;
        this.pass = pass;
        this.type = type;
        this.rootUrl = rootUrl;
        this.fromUrl = fromUrl;
        this.text = text;
        this.html = html;
        this.title = title;
        this.startTime = startTime;
        this.crawlTime = crawlTime;
        this.publishTime = publishTime;
        this.depthfromSeed = depthfromSeed;
        this.tag = tag;
        this.count = count;
        this.fetched = fetched;
        this.author = author;
        this.sourceName = sourceName;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    public String getFromUrl() {
        return fromUrl;
    }

    public void setFromUrl(String fromUrl) {
        this.fromUrl = fromUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Date getCrawlTime() {
        return crawlTime;
    }

    public void setCrawlTime(Date crawlTime) {
        this.crawlTime = crawlTime;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public long getDepthfromSeed() {
        return depthfromSeed;
    }

    public void setDepthfromSeed(long depthfromSeed) {
        this.depthfromSeed = depthfromSeed;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public boolean isFetched() {
        return fetched;
    }

    public void setFetched(boolean fetched) {
        this.fetched = fetched;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getTextPTag() {
        return textPTag;
    }

    public void setTextPTag(String textPTag) {
        this.textPTag = textPTag;
    }

    public JSONArray getTags() {
        return tags;
    }

    public void setTags(JSONArray tags) {
        this.tags = tags;
    }

    public void setTags(String tags) {
        try {
            this.tags = JSONArray.parseArray(tags);
        } catch (Exception e) {
            this.tags = new JSONArray();
        }
    }

    public JSONArray getCategories() {
        return categories;
    }

    public void setCategories(JSONArray categories) {
        this.categories = categories;
    }

    public void setCategories(String categories) {
        try {
            this.categories = JSONArray.parseArray(categories);
        } catch (Exception e) {
            this.categories = new JSONArray();
        }
    }

    public String toJSONString() {

        return JSONObject.toJSONString(this);
    }
}
