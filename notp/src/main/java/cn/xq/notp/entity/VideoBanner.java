package cn.xq.notp.entity;

import java.util.Date;

/**
 * @author qiong.xie
 * @description 视频轮播
 * @date 2021/4/14
 */
public class VideoBanner {

    private int id;
    private String url; // 跳转地址
    private String img; // 图片地址
    private Date createTime; // 创建时间
    private int weight; // 权重 数字越小排越前

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
