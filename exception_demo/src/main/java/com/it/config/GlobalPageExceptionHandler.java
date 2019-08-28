package com.it.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * @author wangchao
 * @description 全局页面处理类
 * @date 2019/08/16 15:15
 */
@ControllerAdvice
public class GlobalPageExceptionHandler {

    public static String errorPage = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandle(HttpServletRequest request, Exception e) {
        ModelAndView modelAndView = new ModelAndView(errorPage);
        System.out.println("URL" + request.getRequestURL());
        modelAndView.addObject("url",request.getRequestURI());
        modelAndView.addObject("exception",e.getMessage());
        return modelAndView;
    }
}
