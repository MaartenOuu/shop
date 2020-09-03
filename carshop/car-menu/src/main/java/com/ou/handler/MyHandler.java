package com.ou.handler;

import com.ou.entity.ResultCommon;
import com.ou.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.ou.controller")
public class MyHandler {

    @ExceptionHandler(value = NullPointerException.class)
    public ResultCommon handler(){
        return ResultUtil.error("输入不能为空");
    }
}
