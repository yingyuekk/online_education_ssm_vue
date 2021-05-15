package cn.xq.notp.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author qiong.xie
 * @description 使用Servlet3.0 开发原生接口
 * @date 2021/4/19
 */
@WebServlet(urlPatterns = "/demo",name = "notpServlet")
public class NotpServlet extends HttpServlet {

    private final static Logger logger = LoggerFactory.getLogger(NotpServlet.class);

    @Override
    public void init() throws ServletException {
        logger.info("===================== NotpServlet.init() =====================");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        logger.info("===================== NotpServlet.doGet() "+path+" =====================");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("进入Servlet GET请求接口 ");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        logger.info("===================== NotpServlet.doPost() "+path+" =====================");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("进入Servlet Post请求接口 ");
        writer.flush();
        writer.close();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String path = request.getServletPath();
        logger.info("===================== NotpServlet.service() "+path+" =====================");
        String method = request.getMethod();
        if (method.equals("GET")){
            this.doGet(request,response);
        }else if(method.equals("POST")){
            this.doPost(request,response);
        }
    }
}
