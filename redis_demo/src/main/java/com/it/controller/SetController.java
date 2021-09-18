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
public class SetController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @GetMapping("/set")
    public Object set() {
        redisTemplate.opsForValue().set("name", "test");
        return redisTemplate.opsForValue().get("name");
    }
}
