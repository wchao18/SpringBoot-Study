package com.it.algorithm;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangchao
 * @description TODO
 * @date 2022/04/18 21:17
 */
public class RateLimiterSimpleWindow {
    // 阈值
    private static Integer QPS = 2;
    // 时间窗口（毫秒）
    private static long TIME_WINDOWS = 1000;
    // 计数器
    private static AtomicInteger REQ_COUNT = new AtomicInteger();

    private static long START_TIME = System.currentTimeMillis();

    public synchronized static boolean tryAcquire() {
        if ((System.currentTimeMillis() - START_TIME) > TIME_WINDOWS) {
            REQ_COUNT.set(0);
            START_TIME = System.currentTimeMillis();
        }
        return REQ_COUNT.incrementAndGet() <= QPS;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            //Thread.sleep(200);
            Thread.sleep(450);
            LocalTime now = LocalTime.now();
            if (!tryAcquire()) {
                System.out.println(now + " 被限流");
            } else {
                System.out.println(now + " 做点什么");
            }
        }
    }
}
