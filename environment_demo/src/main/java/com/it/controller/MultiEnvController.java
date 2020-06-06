package com.it.controller;

import com.it.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @description 环境测试
 * @date 2020/06/06 10:21
 */
@RestController
public class MultiEnvController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String say() {
        return helloService.say();
    }


}
