package com.it.spi.service.impl;

import com.it.spi.api.SpringApiService;

public class SpringApiServiceImpl implements SpringApiService {
    @Override
    public void test() {
        System.out.println("测试spring的api");
    }
}
