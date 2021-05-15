package cn.xq.notp.dao;

import cn.xq.notp.dto.ChapterDto;

import java.util.List;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/15
 */
public interface ChapterMapper {

    List<ChapterDto> findChapterByVideoId(int videoId);
}
