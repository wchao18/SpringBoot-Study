package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//等价于@EnableAutoConfiguration和@ComponentScan
/*@EnableAutoConfiguration
@ComponentScan(value = {"com.it"})*/
@ImportResource(value = {"classpath:/spring.xml"} )
public class BootfirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootfirstApplication.class, args);
    }

}
