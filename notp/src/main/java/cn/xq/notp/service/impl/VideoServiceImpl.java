package cn.xq.notp.service.impl;

import cn.xq.notp.dao.*;
import cn.xq.notp.dto.ChapterDto;
import cn.xq.notp.entity.Episode;
import cn.xq.notp.entity.PlayRecord;
import cn.xq.notp.entity.Video;
import cn.xq.notp.entity.VideoOrder;
import cn.xq.notp.exception.NotpException;
import cn.xq.notp.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/15
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private EpisodeMapper episodeMapper;
    @Autowired
    private VideoOrderMapper videoOrderMapper;
    @Autowired
    private PlayRecordMapper playRecordMapper;

    @Override
    public List<Video> list() {
        return videoMapper.findAll();
    }

    @Override
    public Video getInfo(int id) {
        return videoMapper.findById(id);
    }

    @Override
    public List<ChapterDto> getChapterById(int id) {
        List<ChapterDto> list = chapterMapper.findChapterByVideoId(id);
        for (ChapterDto chapterDto : list){
            List<Episode> episodeList = episodeMapper.findEpisode(chapterDto.getId(),chapterDto.getVideoId());
            chapterDto.setEpisodeList(episodeList);
        }
        return list;
    }

    @Override
    public List<VideoOrder> getVideoOrderByUserId(Integer userId) {
        return videoOrderMapper.findVideoOrderByUserId(userId);
    }

    @Override
    public int addVideoOrder(int videoId, Integer userId) {
        /** 判断该视频是否已经购买了 */
        VideoOrder videoOrderTemp = videoOrderMapper.findVideoOrderByUserIdAndVideoId(userId,videoId,1);
        if (videoOrderTemp != null){return 0;}

        Video video = videoMapper.findById(videoId);
        VideoOrder videoOrder = new VideoOrder();

        videoOrder.setOutTradeNo(UUID.randomUUID().toString());
        videoOrder.setState(1);
        videoOrder.setCreateTime(new Date());
        videoOrder.setTotalFee(video.getPrice());
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setVideoImg(video.getCoverImg());
        videoOrder.setUserId(userId);

        int row = videoOrderMapper.insertVideoOrder(videoOrder);

        /** 生成播放记录 */
        if (row > 0){
            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);
            if(episode == null){
                throw  new NotpException(-1,"视频没有集信息，请运营人员检查");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecordMapper.saveRecord(playRecord);
        }
        return row;
    }
}
