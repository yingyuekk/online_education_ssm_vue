package cn.xq.notp.service.impl;

import cn.xq.notp.dao.VideoBannerMapper;
import cn.xq.notp.entity.VideoBanner;
import cn.xq.notp.service.VideoBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/15
 */
@Service
public class VideoBannerServiceImpl implements VideoBannerService {

    @Autowired
    private VideoBannerMapper videoBannerMapper;

    @Override
    public List<VideoBanner> list() {
        return videoBannerMapper.findAll();
    }
}
