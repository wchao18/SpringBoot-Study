package com.it.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/09/22 20:48
 */
@Mapper
public interface OrderDao {

    @Insert("insert into t_order(price,user_id,status) values (#{price},#{user_id},#{status}")
    void insertOrder(@Param("price") BigDecimal price, @Param("user_id") Long uerId, @Param("status") String status);
}
