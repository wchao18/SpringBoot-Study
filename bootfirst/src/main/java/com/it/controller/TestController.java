package com.it.controller;

import com.it.dto.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/14 16:46
 */
@RestController
public class TestController {

    @Resource
    private People people2; //config和spring.xml各实例化了People对象


    @RequestMapping("/test")
    public String sayHello() {
      return people2.getName();
    }


}
