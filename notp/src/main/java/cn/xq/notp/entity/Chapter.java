package cn.xq.notp.entity;

import java.util.Date;

/**
 * @author qiong.xie
 * @description 视频章节
 * @date 2021/4/14
 */
public class Chapter {

    private int id;
    private int videoId; // 视频主键
    private String title; // 章节名称
    private String ordered; // 章节顺序
    private Date createTime; // 创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrdered() {
        return ordered;
    }

    public void setOrdered(String ordered) {
        this.ordered = ordered;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
