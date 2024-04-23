package com.cw.mfc.business.aop;

import com.cw.mfc.business.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<?> exceptionHandler(Exception e) {
        log.error("系统异常", e);
        return Result.error();
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Result<?> bindExceptionHandler(BindException e) {
        log.warn("请求参数异常：{}",  e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return Result.error(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
