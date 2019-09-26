package com.it;

import com.github.pagehelper.PageHelper;
import com.it.dao.domain.User;
import com.it.dao.mapper1.UserMapper1;
import com.it.dao.mapper2.UserMapper2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDatasourceDemoApplicationTests {

    @Autowired
    private UserMapper1 userMapper1;

    @Autowired
    private UserMapper2 userMapper2;

    @Test
    public void test1() {
        PageHelper.startPage(1,10);
        List<User> users = userMapper1.selectList();
    }


    @Test
    public void test2() {
        userMapper2.selectList();
    }

}
