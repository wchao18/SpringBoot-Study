package com.it.controller;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/09/05 14:40
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @CrossOrigin(origins = {"http://127.0.0.1:8083","http://127.0.0.1:8082"})
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public HashMap<String, Object> get(@RequestParam String name) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "hello world");
        map.put("name", name);
        return map;
    }
}
