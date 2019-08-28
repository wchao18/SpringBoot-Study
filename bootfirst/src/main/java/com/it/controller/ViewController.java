package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/14 16:46
 */
@Controller
public class ViewController {

    @RequestMapping("/view")
    public String showView(String mid, Model model) {
        model.addAttribute("url", "www.baidu.com");
        model.addAttribute("mid", mid);
        return "message/message_show";//默认是html的后缀的,可以修改的
    }


}
