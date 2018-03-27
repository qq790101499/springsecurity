package com.platform.zxx.controller;


import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;


@ControllerAdvice
public class ExceptionHandlerAdvice {

//    @ExceptionHandler(SQLException.class)
//    @ResponseBody
//    public String handleException(SQLException e) {
//        e.printStackTrace();
//        return "sql异常";
//    }


}
