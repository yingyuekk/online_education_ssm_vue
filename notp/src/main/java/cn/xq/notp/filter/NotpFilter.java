package cn.xq.notp.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/19
 */
@WebFilter(urlPatterns = "/*",filterName = "notpFilter")
public class NotpFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(NotpFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("===================== NotpFilter.init() =====================");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getServletPath();
        logger.info("===================== NotpFilter.doFilter()"+path+" =====================");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("===================== NotpFilter.destroy() =====================");
    }
}
