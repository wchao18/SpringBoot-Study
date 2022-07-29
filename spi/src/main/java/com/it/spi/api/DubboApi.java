package com.it.spi.api;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("b")
public interface DubboApi {

    //注解进行了标注，表示该方法在自动生成的子类中是需要动态实现的方法
    @Adaptive
    void testDubbo(String param);

    void test2();
}
