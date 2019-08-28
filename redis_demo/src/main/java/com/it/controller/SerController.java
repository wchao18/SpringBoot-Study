package com.it.controller;

import com.it.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/21 14:40
 */
@RestController
public class SerController {


    @Autowired
    private RedisTemplate<String, Object> objectRedisTemplate;


    @GetMapping("/serial")
    public String serial() {
        User user = new User();
        user.setAddress("浙江");
        user.setAge(25);
        user.setName("哈哈");
        objectRedisTemplate.opsForValue().set("object",user);
        Object object = objectRedisTemplate.opsForValue().get("object");
        System.out.println(object);
        return "success";
    }

}
