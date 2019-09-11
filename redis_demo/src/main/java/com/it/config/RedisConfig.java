package com.it.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/09/10 18:36
 */
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisConfig {

    private String host;

    private Integer port;

    private Integer database;

    private String password;

    private Integer timeout;


}
