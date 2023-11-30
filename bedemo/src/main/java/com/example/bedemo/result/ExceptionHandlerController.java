package com.example.bedemo.result;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerController {
    /**
     * ExceptionHandler(CommonRuntimeException.class)
     * 表示当前处理器只处理CommonRuntimeException异常
     * @return
     */
    @ExceptionHandler(CommonRuntimeException.class)
    @ResponseBody
    public Result handlerException(CommonRuntimeException e){
        //异常返回false，Result是上一篇接口返回对象。
        return new Result(e.getStatus(),e.getMessage());
    }

}
