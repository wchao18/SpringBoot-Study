package com.it;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//代码设置了分页插件，不需要自动配置类，要排除掉
@SpringBootApplication(exclude = PageHelperAutoConfiguration.class)
public class MultiDatasourceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceDemoApplication.class, args);
    }

}
