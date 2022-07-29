package com.it.spi.service.impl;

import com.it.spi.api.DubboApi;

public class ADubboServiceImpl implements DubboApi {

    @Override
    public void testDubbo(String param) {
        System.out.println("A:" + param);
    }

    @Override
    public void test2() {
        System.out.println("A");
    }
}
