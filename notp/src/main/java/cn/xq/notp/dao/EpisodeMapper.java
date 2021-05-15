package cn.xq.notp.dao;

import cn.xq.notp.entity.Episode;

import java.util.List;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/15
 */
public interface EpisodeMapper {

    List<Episode> findEpisode(int chapterId, int videoId);

    Episode findFirstEpisodeByVideoId(int videoId);
}
