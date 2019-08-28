package com.it.config;

import com.it.dto.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/15 20:57
 */
@Configuration
public class Configure {

    @Bean("people2")
    public People people(){
        return new People();
    }
}

