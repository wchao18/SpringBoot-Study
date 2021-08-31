package com.it.lock.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ClearOrderTask {

    @Autowired
    private RedisLockFactory factory;
    /**
     * 模拟定时清理订单
     */
    @Scheduled(cron = "0/10 * * ? * *")
    public void clearOrderTask() throws InterruptedException {
        // 获取锁对象
        RedisLock lock = factory.getReentrantLock("lock1");
        // 尝试获取锁
        boolean isLock = lock.tryLock(50);
        if(!isLock){
            // 获取锁失败
            log.error("获取锁失败，定时任务终止！");
            return;
        }
        try {
            // 获取锁成功
            log.info("获取锁成功，开始任务！");
            clearOrder();
        }finally {
            log.warn("任务执行完毕，释放锁！");
            lock.unLock();
        }

    }

    public void clearOrder() throws InterruptedException {
        log.info("开始清理订单");
        Thread.sleep(5000);
        log.info("开始恢复库存");
    }
}
