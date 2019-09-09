package com.it.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/05/07 23:38
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index2",method = RequestMethod.GET)
    public String test() {
        return "index2";
    }
}
