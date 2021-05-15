package cn.xq.notp.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/18
 */
@PropertySource({"classpath:resource.properties"})
@Service
public class DemoService {

    @Value("${demo.name}")
    private String name;
    @Value("${demo.age}")
    private int age;

    public Map<String,String> demo1(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name",name);
        map.put("age",Integer.toString(age));
        return map;
    }
}
