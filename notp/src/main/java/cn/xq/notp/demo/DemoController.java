package cn.xq.notp.demo;

import cn.xq.notp.exception.NotpException;
import cn.xq.notp.task.NotpFuture;
import cn.xq.notp.task.NotpTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/19
 */
@RestController
public class DemoController {

    @Autowired
    private NotpTask notpTask;
    @Autowired
    private NotpFuture notpFuture;

    @RequestMapping("/taskDemo")
    public Map<String,String> demo1(){
        Map<String, String> map = new HashMap<>();
        map.put("name","Jack");
        notpTask.test1();
        notpTask.test2();
        notpTask.test3();
        notpTask.test4();
        notpTask.test5();
        notpTask.test6();
        map.put("age","12");
        return map;
    }

    @RequestMapping("/taskDemo1")
    public Map<String,String> demo2(){
        Map<String, String> map = new HashMap<>();
        Future<String> task1,task2,task3,task4,task5,task6;
        map.put("name","Jack");
        try {
            task1 = notpFuture.task1();
            task2 =notpFuture.task2();
            task3 = notpFuture.task3();
            task4 = notpFuture.task4();
            task5 = notpFuture.task5();
            task6 = notpFuture.task6();
        } catch (InterruptedException e) {
            throw new NotpException(-1,e.getMessage());
        }
        map.put("age","12");
        map.put("task1",task1.toString());
        map.put("task2",task2.toString());
        map.put("task3",task3.toString());
        map.put("task4",task4.toString());
        map.put("task5",task5.toString());
        map.put("task6",task6.toString());
        return map;
    }
}
