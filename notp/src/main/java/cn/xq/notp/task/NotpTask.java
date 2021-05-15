package cn.xq.notp.task;

import cn.xq.notp.exception.NotpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author qiong.xie
 * @description 异步任务
 * @date 2021/4/19
 */
@Component
public class NotpTask {

    private final static Logger logger = LoggerFactory.getLogger(NotpTask.class);

    @Async
    public void test1(){
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            throw new NotpException(-1,e.getMessage());
        }
        logger.info("===================== 异步任务 NotpTask.test1() =====================");
    }
    @Async
    public void test2(){
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            throw new NotpException(-1,e.getMessage());
        }
        logger.info("===================== 异步任务 NotpTask.test2() =====================");
    }
    @Async
    public void test3(){
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            throw new NotpException(-1,e.getMessage());
        }
        logger.info("===================== 异步任务 NotpTask.test3() =====================");
    }
    @Async
    public void test4(){
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            throw new NotpException(-1,e.getMessage());
        }
        logger.info("===================== 异步任务 NotpTask.test4() =====================");
    }
    @Async
    public void test5(){
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            throw new NotpException(-1,e.getMessage());
        }
        logger.info("===================== 异步任务 NotpTask.test5() =====================");
    }
    @Async
    public void test6(){
        try {
            Thread.sleep(400L);
        } catch (InterruptedException e) {
            throw new NotpException(-1,e.getMessage());
        }
        logger.info("===================== 异步任务 NotpTask.test6() =====================");
    }
}
