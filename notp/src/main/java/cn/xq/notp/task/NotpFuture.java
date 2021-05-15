package cn.xq.notp.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author qiong.xie
 * @description 异步任务 Future
 * @date 2021/4/19
 */
@Component
public class NotpFuture {

    private final static Logger logger = LoggerFactory.getLogger(NotpFuture.class);

    @Async
    public Future<String> task1() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(0);
        long currentTimeMillis1 = System.currentTimeMillis();
        logger.info("======== task1任务耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms ========");
        return new AsyncResult<String>("task1执行完毕");
    }

    @Async
    public Future<String> task2() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(0);
        long currentTimeMillis1 = System.currentTimeMillis();
        logger.info("======== task2任务耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms ========");
        return new AsyncResult<String>("task2执行完毕");
    }

    @Async
    public Future<String> task3() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(0);
        long currentTimeMillis1 = System.currentTimeMillis();
        logger.info("======== task3任务耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms ========");
        return new AsyncResult<String>("task3执行完毕");
    }

    @Async
    public Future<String> task4() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(0);
        long currentTimeMillis1 = System.currentTimeMillis();
        logger.info("======== task4任务耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms ========");
        return new AsyncResult<String>("task4执行完毕");
    }

    @Async
    public Future<String> task5() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(0);
        long currentTimeMillis1 = System.currentTimeMillis();
        logger.info("======== task5任务耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms ========");
        return new AsyncResult<String>("task5执行完毕");
    }

    @Async
    public Future<String> task6() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(0);
        long currentTimeMillis1 = System.currentTimeMillis();
        logger.info("======== task6任务耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms ========");
        return new AsyncResult<String>("task6执行完毕");
    }
}
