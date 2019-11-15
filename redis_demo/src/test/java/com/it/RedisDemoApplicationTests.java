package com.it;

import com.it.controller.SerController;
import com.it.controller.StringController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {

    @Autowired
    private SerController serController;

    @Autowired
    private StringController stringController;

    @Test
    public void serial() {
        serController.serial();
    }

    @Test
    public void string() {
        System.out.println(stringController.string());
    }


}
