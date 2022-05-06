package com.it.algorithm;

import com.google.common.util.concurrent.RateLimiter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 谷歌工具类实现令牌桶限流（单机）
 */
public class TokenBucketLimiterGuava {

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.create(2);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
            executorService.execute(() -> {
                System.out.println(time + ":" + rateLimiter.tryAcquire());
            });
            Thread.sleep(250);
        }
        executorService.shutdown();
    }
}
