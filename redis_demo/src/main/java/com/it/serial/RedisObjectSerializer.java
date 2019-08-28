package com.it.serial;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
/**
 * @author wangchao
 * @description redis序列化操作可以序列化所有的类的对象 ，当然这个对象所在类的一定要实现序列化接口
 * @date 2019/08/21 14:53
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

    //准备两个转换器
    private Converter<Object, byte[]> serialize = new SerializingConverter();

    private Converter<byte[], Object> deserialize = new DeserializingConverter();

    private static final byte[] EMPTY_BYTE = new byte[0];

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o == null) {
            return EMPTY_BYTE;
        }
        return serialize.convert(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        return deserialize.convert(bytes);
    }
}
