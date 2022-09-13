package com.it.skywalking;

import com.it.ServiceBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SkywalkingApplicationTests {

    @Autowired
    private ServiceBean serviceBean;

    @Test
    void contextLoads() {
        System.out.println(serviceBean.say("springboot-starter测试"));
    }

}
