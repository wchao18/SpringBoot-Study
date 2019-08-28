package com.it.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/28 10:09
 */
@Configuration
public class MyAppInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("company.name","哈哈");
        builder.withDetail("app.version","1.0.0");
    }
}
