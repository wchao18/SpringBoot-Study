package com.it.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public Redisson redisson() {
        StringBuffer stringBuffer = new StringBuffer();
        Config config = new Config();
        config.useSingleServer()
                .setAddress(stringBuffer.append("redis://").append(redisProperties.getHost())
                        .append(":")
                        .append(redisProperties.getPort()).toString()).setDatabase(redisProperties.getDatabase()).setPassword(redisProperties.getPassword());
        return (Redisson) Redisson.create(config);
    }
}
