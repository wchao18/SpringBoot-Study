package com.it.lock.redis;

public interface RedisLock {

    boolean tryLock(long releaseTime);

    void unLock();
}
