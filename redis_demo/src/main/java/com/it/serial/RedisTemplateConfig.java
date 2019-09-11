package com.it.serial;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/21 15:09
 */
@Configuration
public class RedisTemplateConfig {


   /* //操作字符串
    redisTemplate.opsForValue();
    //操作hash
    redisTemplate.opsForHash();
    //操作list
    redisTemplate.opsForList();
    //操作set
    redisTemplate.opsForSet();
    //操作有序set
    redisTemplate.opsForZSet();*/

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //jackson的序列化
        //redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        //fastjson的序列化
        redisTemplate.setValueSerializer(new FastjsonSerializer(Object.class));
        //普通自定义的序列化
        //redisTemplate.setValueSerializer(new RedisObjectSerializer());
        return redisTemplate;
    }
}
