package com.it.init;

import com.it.filter2.RedisBloomFilter;
import com.it.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class RedisDataInit {

    @Autowired
    RedisBloomFilter redisBloomFilter;

    @Autowired
    private UserMapper userMapper;

    @PostConstruct
    public void init() {
        List<Long> ids = userMapper.selectAllId();
        for (Long id : ids) {
            redisBloomFilter.put(String.valueOf(id));
        }
    }
}
