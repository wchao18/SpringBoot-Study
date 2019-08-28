package com.it.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/27 18:25
 */
@Configuration
public class AppHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("info","这个应用还活着").withDetail("address","浙江杭州").build();
    }
}
