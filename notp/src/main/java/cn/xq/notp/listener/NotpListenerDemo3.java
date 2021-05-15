package cn.xq.notp.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author qiong.xie
 * @description 应⽤用启动监听
 * @date 2021/4/19
 */
@WebListener
public class NotpListenerDemo3 implements ServletContextListener {

    private final static Logger logger = LoggerFactory.getLogger(NotpListenerDemo3.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("===================== 应⽤用启动监听 NotpListenerDemo3.contextInitialized() =====================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("===================== 应⽤用启动监听 NotpListenerDemo3.contextDestroyed() =====================");
    }
}
