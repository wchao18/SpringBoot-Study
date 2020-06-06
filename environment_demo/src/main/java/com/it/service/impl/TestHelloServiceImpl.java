package com.it.service.impl;

import com.it.service.HelloService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/06/06 10:04
 */
@Service
@Profile("test")
public class TestHelloServiceImpl implements HelloService {
    @Override
    public String say() {
        return "test";
    }
}
