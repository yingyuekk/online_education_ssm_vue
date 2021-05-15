package cn.xq.notp.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author qiong.xie
 * @description 请求监听
 * @date 2021/4/19
 */
@WebListener(value = "notpListenerDemo1")
public class NotpListenerDemo1 implements ServletRequestListener {

    private final static Logger logger = LoggerFactory.getLogger(NotpListenerDemo1.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("===================== 请求监听 NotpListenerDemo1.requestDestroyed() "+request.getServletPath()+" =====================");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("===================== 请求监听 NotpListenerDemo1.requestInitialized() "+request.getServletPath()+" =====================");
    }
}
