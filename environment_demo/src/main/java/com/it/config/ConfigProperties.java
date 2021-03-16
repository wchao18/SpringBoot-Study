package com.it.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/07/30 17:48
 */
@Component
@ConfigurationProperties(prefix = "config")
@PropertySource(value = "classpath:config/config.properties", encoding = "UTF-8")
public class ConfigProperties {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
