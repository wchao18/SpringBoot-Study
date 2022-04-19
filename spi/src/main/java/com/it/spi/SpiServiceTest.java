package com.it.spi;

import com.it.spi.api.ApiService;

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
        ServiceLoader<ApiService> load = ServiceLoader.load(ApiService.class);
        final Optional<ApiService> serializer = StreamSupport.stream(load.spliterator(), false)
                .findFirst();
        ApiService apiService = serializer.get();
        apiService.sayHello();
    }
}
