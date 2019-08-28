package com.it.controller;

import com.it.base.AbstractBaseController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/14 16:46
 */
//@RestController   //影响了视图的显示，ViewController
public class MessageController extends AbstractBaseController {

    @RequestMapping("/message/{key}")
    public String getMassage(@PathVariable("key") String key) {
        return this.getMessage(key);
    }
}
