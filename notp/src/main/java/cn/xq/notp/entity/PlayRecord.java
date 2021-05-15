package cn.xq.notp.entity;

import java.util.Date;

/**
 * @author qiong.xie
 * @description 播放记录
 * @date 2021/4/14
 */
public class PlayRecord {

    private int id;
    private int userId; // 用户ID
    private int videoId; // 视频ID
    private int currentNum; // 当前播放第几集
    private int episodeId; // 当前播放第几集视频id
    private Date createTime; // 创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
