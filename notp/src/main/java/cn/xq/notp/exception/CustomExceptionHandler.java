package cn.xq.notp.exception;

import cn.xq.notp.common.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author qiong.xie
 * @description 异常处理类
 * @date 2021/4/19
 */
@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultData handle(Exception e){
        logger.error("[ 系统异常 ]{}",e.getMessage());
        if (e instanceof NotpException){
            NotpException notpException = (NotpException) e;
            return ResultData.build(notpException.getStatus(),notpException.getMessage(),null);
        }
        return ResultData.build(-1,"全局异常，未知错误",null);
    }
}
