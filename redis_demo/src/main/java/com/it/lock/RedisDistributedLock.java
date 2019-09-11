package com.it.lock;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author wangchao
 * @description redis分布式锁
 * @date 2019/09/10 18:05
 */
@Component
@Slf4j
public class RedisDistributedLock {

    @Autowired
    private RedissonManager redissonManager;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void redissonTask() {
        RLock rlock = redissonManager.getRedisson().getLock("TEST_LOCK");
        boolean tryLockResult = false;
        long waitTime = 0;//这个有坑，一般设置为0,否则，同一时刻会有两个任务同时执行
        long leaseTime = 50;
        try {
            //数据类型为hash
            tryLockResult = rlock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
            if (tryLockResult) {
                log.info("{}获取到锁", Thread.currentThread().getName());
                //执行方法
            } else {
                log.info("{}未获取到锁", Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            log.error("获取锁异常" + e.getMessage(), e);
        } finally {
            if (!tryLockResult) {
                return;
            }
            rlock.unlock();
            log.info("释放锁");
        }
    }
}
