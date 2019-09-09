package com.it.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/18 20:09
 */

@RestController
public class TestController {

    @RequestMapping("/value")
    public String getValue(){
        return "success";
    }

}
