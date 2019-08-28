package com.it.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/14 16:46
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
      return "helloController";
    }

    @RequestMapping("/sum")
    public Integer sum(int sum1) {
        return sum1 + 3;
    }

    @RequestMapping("/http")
    public String getHttpInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println(httpServletRequest.getRemoteAddr());
        System.out.println(httpServletRequest.getServletPath());
        System.out.println(httpServletRequest.getContextPath());
        System.out.println(httpServletRequest.getSession().getId());
        System.out.println(httpServletRequest.getServletContext().getRealPath("/application.properties"));
        System.out.println(httpServletResponse.getContentType());
        System.out.println(httpServletResponse.getCharacterEncoding());
        return "success";
    }
}
