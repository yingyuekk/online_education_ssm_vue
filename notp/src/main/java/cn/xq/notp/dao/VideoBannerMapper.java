package cn.xq.notp.dao;

import cn.xq.notp.entity.VideoBanner;

import java.util.List;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/15
 */
public interface VideoBannerMapper {
    List<VideoBanner> findAll();
}
