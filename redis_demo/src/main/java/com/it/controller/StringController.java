package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @description redis的string操作
 * @date 2019/08/23 11:32
 */
@RestController
public class StringController {

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;


    @GetMapping("/string")
    public String string() {
        stringRedisTemplate.opsForValue().set("name", "哈哈");
        return stringRedisTemplate.opsForValue().get("name");
    }
}
