package com.it.jdbc_demo;

import com.alibaba.fastjson.JSON;
import com.it.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcDemoApplicationTests {

    @Autowired
    private UserController testController;

    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoads() {
        System.out.println("数据源" + dataSource);
    }

    @Test
    public void testGet(){
        System.out.println("*****************" + JSON.toJSONString(testController.getUsers()));
    }


}
