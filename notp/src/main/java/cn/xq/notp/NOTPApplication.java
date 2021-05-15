package cn.xq.notp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("cn.xq.notp.dao")
@ServletComponentScan({"cn.xq.notp.filter","cn.xq.notp.servlet","cn.xq.notp.listener","cn.xq.notp.scheduled","cn.xq.notp.task"})
@EnableScheduling
@EnableAsync
public class NOTPApplication {

    public static void main(String[] args) {
        SpringApplication.run(NOTPApplication.class, args);
    }

}
