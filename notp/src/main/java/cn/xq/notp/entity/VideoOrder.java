package cn.xq.notp.entity;

import java.util.Date;

/**
 * @author qiong.xie
 * @description 视频订单
 * @date 2021/4/14
 */
public class VideoOrder {

    private int id;
    private String outTradeNo; //订单唯一标识
    private int state; // 支付状态 0表示未支付，1表示已支付
    private Date createTime; // 订单生成时间
    private int totalFee; // 支付金额，单位分
    private int videoId; // 视频主键
    private String videoTitle; // 视频标题
    private String videoImg; // 视频图片
    private int userId; // 用户id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
