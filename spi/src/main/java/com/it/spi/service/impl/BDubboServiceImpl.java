package com.it.spi.service.impl;

import com.it.spi.api.DubboApi;

public class BDubboServiceImpl implements DubboApi {

    @Override
    public void testDubbo(String param) {
        System.out.println("B:" + param);
    }

    @Override
    public void test2() {
        System.out.println("B");
    }
}
