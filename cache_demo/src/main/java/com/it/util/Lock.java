package com.it.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public interface Lock {
    void lock(String key);
    boolean tryLock(String key);
    void unlock(String key) throws Exception;
}
