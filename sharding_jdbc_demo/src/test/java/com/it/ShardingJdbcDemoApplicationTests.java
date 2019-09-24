package com.it;

import com.it.dao.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcDemoApplicationTests {

    @Autowired
    private OrderDao orderDao;


    @Test
    public void testInsert() {
        for (int i = 0; i < 5; i++) {
            orderDao.insertOrder(new BigDecimal(10), 1L, "test");
        }
    }

}
