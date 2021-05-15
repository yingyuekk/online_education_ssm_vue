package cn.xq.notp.dao;

import cn.xq.notp.dto.ChapterDto;
import cn.xq.notp.entity.Episode;
import cn.xq.notp.entity.Video;

import java.util.List;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/15
 */
public interface VideoMapper {

    List<Video> findAll();

    Video findById(int id);
}
