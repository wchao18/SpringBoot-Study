package com.it.controller;

import com.it.filter.RedisBloomFilter;
import com.it.mapper.UserMapper;
import com.it.pojo.NullValueResultDO;
import com.it.pojo.UserPojo;
import com.it.util.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wangchao
 * @description 缓存穿透（数据库中没有,缓存中也没有）、缓存击穿（数据库中有，缓存中没有）
 * @date 2019/10/22 18:02
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisBloomFilter redisBloomFilter;

    @Autowired
    private RedisLock redisLock;

    /**
     * 缓存穿透解决方案1
     */
    @GetMapping("/resolve")
    public Object resolve(@RequestParam("id") String id) {

        Object s = redisTemplate.opsForValue().get(id);
        if (!StringUtils.isEmpty(s)) {
            if (s instanceof NullValueResultDO) {
                return null;
            }
            return s;
        }
        log.info("查询数据库");
        UserPojo user = userMapper.selectByPrimaryKey(Long.valueOf(id));
        if (user != null) {
            redisTemplate.opsForValue().set(id, user);
            return user;
        } else {
            //解决缓存穿透，缓存空对象
            redisTemplate.opsForValue().set(id, new NullValueResultDO(), 50, TimeUnit.SECONDS);
        }
        log.info("缓存穿透");
        return "fail";
    }

    /**
     * 缓存穿透解决方案2
     */
    @GetMapping("/resolve2")
    public Object resolve2(@RequestParam("id") String id) {

        boolean exist = redisBloomFilter.isExist(id);
        if (!exist) {
            return new NullValueResultDO();
        }
        Object s = redisTemplate.opsForValue().get(id);
        if (!StringUtils.isEmpty(s)) {
            return s;
        }
        log.info("查询数据库");
        UserPojo user = userMapper.selectByPrimaryKey(Long.valueOf(id));
        if (user != null) {
            redisTemplate.opsForValue().set(id, user);
            return user;
        }
        log.info("缓存穿透");
        return "fail";
    }

    /*************************************************************************************/
    /**
     * 缓存击穿解决方案1
     */
    @GetMapping("/resolve3")
    public Object resolve3(@RequestParam("id") String id) {

        Object s = redisTemplate.opsForValue().get(id);
        if (!StringUtils.isEmpty(s)) {
            return s;
        }
        log.info("查询数据库");
        try {
            redisLock.lock(String.valueOf(id));
            Object result = redisTemplate.opsForValue().get(id);
            if (result != null) {
                return result;
            }
            UserPojo user = userMapper.selectByPrimaryKey(Long.valueOf(id));
            if (user != null) {
                redisTemplate.opsForValue().set(id, user);
                return user;
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            redisLock.unlock(String.valueOf(id));
        }
        log.info("缓存穿透");
        return "fail";
    }


}
