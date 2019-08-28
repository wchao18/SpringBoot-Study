package com.it;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = {"com.it.dao.mapper"})
public class JdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

}
