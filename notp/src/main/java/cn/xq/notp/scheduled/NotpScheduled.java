package cn.xq.notp.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

/**
 * @author qiong.xie
 * @description 定时任务
 * @date 2021/4/19
 */
@Component
public class NotpScheduled {

    private final static Logger logger = LoggerFactory.getLogger(NotpScheduled.class);

    /** 每两秒执行一次
     * cron 定时任务表达式 @Scheduled(cron="")  crontab ⼯工具 https://tool.lu/crontab/
     * fixedRate: 定时多久执行一次（上一次开始执行时间点后xx秒再次执行；）
     * fixedDelay: 上一次执行结束时间点后xx秒再次执行
     * */
    //@Scheduled(fixedRate = 2000)
    //@Scheduled(cron = "*/2 * * * * *")
    @Scheduled(fixedDelay = 2000)
    public void tack1(){
        logger.info(new Date()+" Notp 定时任务 ："+ new Random().ints(100,1000));
    }
}
