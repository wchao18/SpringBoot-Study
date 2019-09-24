package com.it.dao.mapper1;

import com.it.dao.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper1 {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectList();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int batchInsert(@Param("list") List<User> list);
}