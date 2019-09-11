package com.it.lock;

import com.it.config.RedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/09/10 18:26
 */
@Component
@Slf4j
public class RedissonManager {

    @Autowired
    private RedisConfig redisConfig;

    private Config config = new Config();

    private Redisson redisson = null;

    public Redisson getRedisson() {
        return redisson;
    }

    @PostConstruct
    public void init() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            config.useSingleServer()
                    .setAddress(stringBuffer.append(redisConfig.getHost()).append(":").append(redisConfig.getPort()).toString())
                    .setDatabase(redisConfig.getDatabase())
                    .setPingTimeout(redisConfig.getTimeout())
                    .setPassword(redisConfig.getPassword());
            redisson = (Redisson) Redisson.create(config);
            log.info("redisson初始化结束");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

}
