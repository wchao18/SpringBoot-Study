package com.it.algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 令牌桶
 */
public class TokenBucketLimiter {

    // 上一次令牌发放时间
    public static long lastTime = System.currentTimeMillis();
    // 桶的容量
    public static int capacity = 2;
    // 令牌生成速度 /s
    public static int rate = 2;
    // 当前令牌数量
    public static AtomicInteger tokens = new AtomicInteger(0);

    public static synchronized boolean isLimited(long taskId, int applyCount) {
        long now = System.currentTimeMillis();
        //时间间隔,单位为 ms
        long gap = now - lastTime;

        //计算时间段内的令牌数
        int reverse_permits = (int) (gap * rate / 1000);
        int all_permits = tokens.get() + reverse_permits;
        // 当前令牌数
        tokens.set(Math.min(capacity, all_permits));
        System.out.println("tokens:" + tokens + "capacity:" + capacity + "gap:" + gap);

        if (tokens.get() < applyCount) {
            // 若拿不到令牌,则拒绝
            return true;
        } else {
            // 还有令牌，领取令牌
            tokens.getAndAdd(-applyCount);
            lastTime = now;
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 6; i++) {
            Thread.sleep(200);
            executorService.execute(() -> {
                System.out.println(isLimited(Thread.currentThread().getId(),1) ? "限流了" : "放行了！");
            });
        }
        executorService.shutdown();
    }
}
