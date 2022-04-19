package com.it.spi.service.impl;

import com.it.spi.api.ApiService;

/**
 * @author wangchao
 * @description TODO
 * @date 2022/04/17 21:42
 */
public class BServiceImpl implements ApiService {
    @Override
    public void sayHello() {
        System.out.println("B service provider");
    }
}
