package com.it.serial;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/22 18:06
 */
public class FastjsonSerializer<T> implements RedisSerializer<T> {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    //fastjosn在反序列化的时候存在漏洞，所以禁用了autotype的功能，需要手动打开

    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }
    private Class<T> clazz;

    FastjsonSerializer(Class<T> param) {
        this.clazz = param;
    }

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o == null) {
            return new byte[0];
        }
        //SerializerFeature 这个是一个盲点
        return JSON.toJSONString(o,SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        return (T) JSON.parseObject(str, clazz);
    }

}
