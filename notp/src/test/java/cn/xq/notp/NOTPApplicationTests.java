package cn.xq.notp;

import cn.xq.notp.demo.Demo;
import cn.xq.notp.demo.DemoComponent;
import cn.xq.notp.demo.DemoService;
import cn.xq.notp.exception.NotpException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.sql.*;
import java.util.Map;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = NOTPApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NOTPApplicationTests {

    @Autowired
    private DemoService demoService;
    @Autowired
    private DemoComponent demoComponent;
    @Autowired
    private Demo demo;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test1(){
        Map<String, String> map = demoService.demo1();
        for (Map.Entry<String,String> entry: map.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    @Test
    public void test2(){
        String demo = demoComponent.demo();
        System.out.println(demo);
    }

    @Test
    public void test3(){
        System.out.println("姓名："+demo.getName()+"  年龄："+demo.getAge());
    }

    /**
     * perform执⾏行行⼀一个RequestBuilder请求
     * andExpect：添加ResultMatcher->MockMvcResultMatchers验证规则
     * andReturn：最后返回相应的MvcResult->Response
     * */
    @Test
    public void test4() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/banner/list")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String result = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println("状态码："+status);
        System.out.println("内容："+result);
    }

    /**
     * 测试原⽣生JDBC连接
     */
    @Test
    public void test5(){
        /** 加载驱动 */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            /** 数据库地址 */
            String url = "jdbc:mysql://localhost:3306/tb_online_study?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
            /** 用户名 */
            String user = "root";
            /** 密码 */
            String password = "123";
            /** 获取连接对象，并连接数据库 */
            Connection conn = DriverManager.getConnection(url,user,password);
            /** sql语句 */
            String sql = "select * from video";
            /** 预编译 */
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("视频ID："+resultSet.getString("id")+"视频标题："+resultSet.getString("title"));
            }
            statement.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
