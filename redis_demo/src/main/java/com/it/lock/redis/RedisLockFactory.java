package com.it.lock.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisLockFactory {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public RedisLock getReentrantLock(String key){
        return new ReentrantRedisLock(redisTemplate,key);
    }
}
