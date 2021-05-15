package cn.xq.notp.dto;

import cn.xq.notp.entity.Chapter;
import cn.xq.notp.entity.Episode;

import java.util.List;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/15
 */
public class ChapterDto extends Chapter {

    private List<Episode> episodeList;

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }
}
