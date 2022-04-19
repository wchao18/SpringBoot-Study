package com.it.spi.service.impl;

import com.it.spi.api.ApiService;

/**
 * @author wangchao
 * @description TODO
 * @date 2022/04/17 21:41
 */
public class AServiceImpl implements ApiService {
    @Override
    public void sayHello() {
        System.out.println("A service provider");
    }
}
