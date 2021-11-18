package com.it.mdc;

import com.it.constant.Constant;
import com.it.controller.LogController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {

    /**
     * Simple Logging Facade for Java (slf4j)
     */
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(2);

    private static final ThreadPoolExecutorMdcWrapper EXECUTOR_MDC_WRAPPER = new ThreadPoolExecutorMdcWrapper(1, 2, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    //注意日志文件要配置：[%X{REQ_ID}]获取REQ_ID的内容
   /* public static void main(String[] args) {
        MDC.put(REQ_ID, UUID.randomUUID().toString());
        logger.info("开始调用服务A，进行业务处理");
        logger.info("业务处理完毕，可以释放空间了，避免内存泄露");
        logger.info("{}", MDC.get(REQ_ID));
        MDC.remove(REQ_ID);
        logger.info("{}", MDC.get(REQ_ID));
    }*/

    public static void main(String[] args) {
        MDC.put(Constant.TRACE_ID, UUID.randomUUID().toString().replace("-", ""));
        logger.info("main thread start");

        new Thread(new MDRunnable(new Runnable() {
            @Override
            public void run() {
                logger.info("new thread start");
            }
        })).start();

        EXECUTOR_SERVICE.execute(new MDRunnable(new Runnable() {
            @Override
            public void run() {
                logger.info("thread pool");
            }
        }));

        EXECUTOR_MDC_WRAPPER.submit(new Runnable() {
            @Override
            public void run() {
                logger.info("thread definite pool");
            }
        });


    }
}
