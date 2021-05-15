package cn.xq.notp.entity;

import java.util.Date;

/**
 * @author qiong.xie
 * @description 视频
 * @date 2021/4/14
 */
public class Video {

    private int id;
    private String title; // 视频标题
    private String summary; // 视频概述
    private String coverImg; // 封面图
    private int price; // 价格
    private Date createTime; // 创建时间
    private double point; // 评分 默认8.7，最高10分

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }
}
