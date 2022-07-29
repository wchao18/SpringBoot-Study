package com.it.spi;

import com.it.spi.api.ApiService;
import com.it.spi.api.DubboApi;
import com.it.spi.api.SpringApiService;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.security.cert.Extension;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * @author wangchao
 * @description TODO
 * @date 2022/04/17 21:48
 */
public class SpiServiceTest {

    public static void main(String[] args) {
        //JDK SPI
        ServiceLoader<ApiService> serviceLoader = ServiceLoader.load(ApiService.class);
        serviceLoader.forEach(ApiService::sayHello);
        System.out.println("===============");
        //Spring SPI
        List<SpringApiService> springApiServices = SpringFactoriesLoader.loadFactories(SpringApiService.class, SpiServiceTest.class.getClassLoader());
        springApiServices.forEach(SpringApiService::test);
        //dubbo SPI
        ExtensionLoader<DubboApi> extensionLoader = ExtensionLoader.getExtensionLoader(DubboApi.class);
        DubboApi adaptiveExtension = extensionLoader.getExtension("a");
        adaptiveExtension.testDubbo("测试");
    }
}
