package cn.xq.notp.interceptor;

import cn.xq.notp.common.JWTUtils;
import cn.xq.notp.common.ResultData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/16
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入到controller之前的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /** 从请求头中获取token */
        String accessToken = request.getHeader("web-Token");
        if (StringUtils.isNotBlank(accessToken)){
            Claims claims = JWTUtils.checkJWT(accessToken);
            if (claims == null){
                //告诉登录过期，重新登录
                sendJsonMessage(response, ResultData.build(2018,"登录过期,请重新登录！！！",null));
                return false;
            }
            Integer id = (Integer) claims.get("id");
            request.setAttribute("user_id", id);

            return true;
        }
        sendJsonMessage(response, ResultData.build(2018,"登录过期,请重新登录！！！",null));

        return false;
    }

    /**
     * 响应json数据给前端
     * @param response
     * @param obj
     */
    public static void sendJsonMessage(HttpServletResponse response, Object obj){

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(objectMapper.writeValueAsString(obj));
            writer.close();
            response.flushBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
