package cn.xq.notp.controller;

import cn.xq.notp.common.ResultData;
import cn.xq.notp.entity.VideoBanner;
import cn.xq.notp.service.VideoBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/15
 */
@RestController
@RequestMapping("/banner")
public class VideoBannerController {

    @Autowired
    private VideoBannerService bannerService;

    @GetMapping("/list")
    public ResultData list(){
        List<VideoBanner> list = bannerService.list();
        return ResultData.ok("获取轮播数据成功！！！",list);
    }
}
