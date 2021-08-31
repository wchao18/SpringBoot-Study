package com.it.lock.redis;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import java.util.Collections;
import java.util.UUID;

public class ReentrantRedisLock implements RedisLock{

    private RedisTemplate<String,Object> redisTemplate;

    private String redisKey;

    private final String THREAD_PREFIX = UUID.randomUUID().toString().replace("-","");

    private static final DefaultRedisScript<Long> LOCK_SCRIPT;

    private static final DefaultRedisScript<Object> UN_LOCK_SCRIPT;

    //单位秒
    private long releaseTime;

    static {
        LOCK_SCRIPT = new DefaultRedisScript<>();
        LOCK_SCRIPT.setScriptSource(new ResourceScriptSource(new ClassPathResource("lock.lua")));
        //这里要加
        LOCK_SCRIPT.setResultType(Long.class);

        UN_LOCK_SCRIPT = new DefaultRedisScript<>();
        UN_LOCK_SCRIPT.setScriptSource(new ResourceScriptSource(new ClassPathResource("unlock.lua")));
    }

    public ReentrantRedisLock(RedisTemplate<String, Object> redisTemplate, String redisKey) {
        this.redisTemplate = redisTemplate;
        this.redisKey = redisKey;
    }

    @Override
    public boolean tryLock(long releaseTime) {
        //记录释放时间
        this.releaseTime = releaseTime;
        //执行脚本
        Long result = redisTemplate.execute(LOCK_SCRIPT, Collections.singletonList(redisKey), THREAD_PREFIX + Thread.currentThread().getId(), this.releaseTime);
        return result!=null && result.intValue() == 1;
    }

    @Override
    public void unLock() {
        //执行脚本
        redisTemplate.execute(UN_LOCK_SCRIPT, Collections.singletonList(redisKey), THREAD_PREFIX + Thread.currentThread().getId(), this.releaseTime);
    }
}
