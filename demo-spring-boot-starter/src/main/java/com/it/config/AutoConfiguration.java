package com.it.config;
import com.it.ServiceBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(annotation = EnableAutoConfigurationTest.class)
public class AutoConfiguration {

    @Bean
    public ServiceBean serviceBean() {
        return new ServiceBean();
    }
}
