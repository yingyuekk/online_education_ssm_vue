package cn.xq.notp.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author qiong.xie
 * @description 会话监听
 * @date 2021/4/19
 */
@WebListener
public class NotpListenerDemo2 implements HttpSessionListener {

    /**
     * 1、request.getSession()，获取即创建session，会触发session监听实现类中的sessionCreated方法；
     * 2、session过了有效时间或主动使用invalidate方法销毁，会触发session监听实现类中的sessionDestroyed方法；
     * */


    private final static Logger logger = LoggerFactory.getLogger(NotpListenerDemo2.class);
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        String path = se.getSession().getServletContext().getContextPath();
        logger.info("===================== 会话监听 NotpListenerDemo2.sessionCreated() "+path+" =====================");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String path = se.getSession().getServletContext().getContextPath();
        logger.info("===================== 会话监听 NotpListenerDemo2.sessionDestroyed() "+path+" =====================");
    }
}
