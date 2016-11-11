package cn.com.cloudpioneer.taskclient.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tianjinjin on 2016/9/1.
 */
public class TaskEntity implements Serializable {

    //爬虫的任务id，唯一
    private String id;

    //用户id，表明任务属于哪个用户，保留字段
    private long idUser = 0;

    //爬虫的任务名
    private String name = "";

    //爬虫任务描述
    private String remark = "";

    //爬虫任务类型
    private int type = 0;

    //爬取深度
    private int depthCrawl = 3;

    //动态爬取深度
    private int depthDynamic = 3;

    //爬取遍数,默认为0
    private int pass = 0;

    //任务权重，默认为0
    private int weight = 0;

    //任务爬取时的线程数，大于0，默认为1
    private int threads = 1;

    //爬取任务完成的次数
    private int completeTimes = 0;

    //任务爬取周期 单位为小时，默认为72
    private int cycleRecrawl = 72;

    //数字标识任务状态，默认为0
    private int status = 0;

    //任务的软删除标识，为true时不能进行爬取，相当于删除，默认为false
    private boolean deleteFlag = false;

    // 任务的激活标识，为 false 时不进行爬取。默认 true
    private boolean activeFlag = true;

    //爬取任务启动的时间
    private Date timeStart;

    //爬取任务的停止时间
    private Date timeStop;

    //任务最后一次爬取的时间
    private Date timeLastCrawl;

    //上次爬取消耗的时间，单位为分钟
    private int costLastCrawl = 0;

    //调度类型
    private int scheduleType = 0;

    //每个任务对应的work数量
    private int workerNumber = 0;

    //任务创建的时间
    private Date createDate;

    // 下载器
    private String downloader = "";

    // 解析器
    private String parser = "";

    // 标签
    private String tags = "[]";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDepthCrawl() {
        return depthCrawl;
    }

    public void setDepthCrawl(int depthCrawl) {
        this.depthCrawl = depthCrawl;
    }

    public int getDepthDynamic() {
        return depthDynamic;
    }

    public void setDepthDynamic(int depthDynamic) {
        this.depthDynamic = depthDynamic;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public int getCompleteTimes() {
        return completeTimes;
    }

    public void setCompleteTimes(int completeTimes) {
        this.completeTimes = completeTimes;
    }

    public int getCycleRecrawl() {
        return cycleRecrawl;
    }

    public void setCycleRecrawl(int cycleRecrawl) {
        this.cycleRecrawl = cycleRecrawl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(Date timeStop) {
        this.timeStop = timeStop;
    }

    public Date getTimeLastCrawl() {
        return timeLastCrawl;
    }

    public void setTimeLastCrawl(Date timeLastCrawl) {
        this.timeLastCrawl = timeLastCrawl;
    }

    public int getCostLastCrawl() {
        return costLastCrawl;
    }

    public void setCostLastCrawl(int costLastCrawl) {
        this.costLastCrawl = costLastCrawl;
    }

    public int getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(int scheduleType) {
        this.scheduleType = scheduleType;
    }

    public int getWorkerNumber() {
        return workerNumber;
    }

    public void setWorkerNumber(int workerNumber) {
        this.workerNumber = workerNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public String getDownloader() {
        return downloader;
    }

    public void setDownloader(String downloader) {
        this.downloader = downloader;
    }

    public String getParser() {
        return parser;
    }

    public void setParser(String parser) {
        this.parser = parser;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {

        return JSONObject.toJSONString(this);
    }
}