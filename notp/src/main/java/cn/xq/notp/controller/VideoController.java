package cn.xq.notp.controller;

import cn.xq.notp.common.ResultData;
import cn.xq.notp.dto.ChapterDto;
import cn.xq.notp.entity.Video;
import cn.xq.notp.entity.VideoOrder;
import cn.xq.notp.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/15
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/list")
    public ResultData list(){
        List<Video> list = videoService.list();
        return ResultData.ok("获取所有视频数据成功！！！",list);
    }

    @GetMapping("/info")
    public ResultData getInfo(@RequestParam int id){
        Video video = videoService.getInfo(id);
        return ResultData.ok("根据ID获取视频详情成功！！！",video);
    }

    @GetMapping("/chapter")
    public ResultData getChapter(@RequestParam int id){
        List<ChapterDto> list = videoService.getChapterById(id);
        return ResultData.ok("根据ID获取章节成功！！！",list);
    }

    @GetMapping("/order")
    public ResultData getOrder(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        List<VideoOrder> list = videoService.getVideoOrderByUserId(userId);
        return list == null ?ResultData.build(2019,"返回订单列表失败！！！",null) :ResultData.ok("返回订单列表成功！！！",list);
    }

    @PostMapping("/pay")
    public ResultData addVideoOrder(@RequestParam int videoId,HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        int result = videoService.addVideoOrder(videoId,userId);
        return result >0 ?ResultData.ok("视频订单下单成功！！！",null) :ResultData.build(2020,"视频订单下单失败！！！",null);
    }
}
