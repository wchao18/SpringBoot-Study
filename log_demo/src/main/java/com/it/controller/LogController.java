package com.it.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/28 17:25
 */
@RestController
public class LogController {

    /**
     * Simple Logging Facade for Java (slf4j)
     */
    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    /**
     * 查看所有的日志级别：http://ip:port/loggers
     * 修改日志级别：post: /loggers/com.it.controller  参数：{"configuredLevel":"ERROR"}
     * 查看日志级别：get:  /loggers/com.it.controller
     */
    @RequestMapping("/log")
    public String log() {
       logger.info("*******info");
       logger.error("******error");
       return "success";
    }

    public static void main(String[] args) {
        logger.info("*******info");
        logger.error("******error");
    }

}
