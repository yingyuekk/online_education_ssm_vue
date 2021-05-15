package cn.xq.notp.dao;

import cn.xq.notp.entity.VideoOrder;

import java.util.List;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/17
 */
public interface VideoOrderMapper {
    List<VideoOrder> findVideoOrderByUserId(Integer userId);

    VideoOrder findVideoOrderByUserIdAndVideoId(Integer userId, int videoId, int state);

    int insertVideoOrder(VideoOrder videoOrder);
}
