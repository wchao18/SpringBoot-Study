package com.it.mapper;

import com.it.pojo.UserPojo;

import java.util.List;


public interface UserMapper {

    UserPojo selectByPrimaryKey(Long id);

    List<Long> selectAllId();

}