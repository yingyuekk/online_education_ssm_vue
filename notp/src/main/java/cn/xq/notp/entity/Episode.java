package cn.xq.notp.entity;

import java.util.Date;

/**
 * @author qiong.xie
 * @description 视频 章集
 * @date 2021/4/14
 */
public class Episode {

    private int id;
    private String title; // 集标题
    private int num; // 第几集,全局顺序
    private int ordered; // 顺序，章里面的顺序
    private String playUrl; // 播放地址
    private int chapterId; // 章节主键id
    private int free; // 0表示免费，1表示首付
    private int videoId; // 视频id
    private Date createTime; // 创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
