package cn.xq.notp.service;

import cn.xq.notp.dto.ChapterDto;
import cn.xq.notp.entity.Video;
import cn.xq.notp.entity.VideoOrder;

import java.util.List;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/15
 */
public interface VideoService {

    List<Video> list();

    Video getInfo(int id);

    List<ChapterDto> getChapterById(int id);

    List<VideoOrder> getVideoOrderByUserId(Integer userId);

    int addVideoOrder(int videoId, Integer userId);
}
