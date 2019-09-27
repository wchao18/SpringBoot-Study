package com.it.service;

import com.it.dao.domain.User;
import com.it.dao.mapper1.UserMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangchao
 * @description 用户服务层
 * @date 2019/09/26 15:46
 */
@Service
public class UserService {

    @Autowired
    private UserMapper1 userMapper1;

    //ps:事务回滚后，主键ID存放在内存当中的
    @Transactional
    public void addUser(User user){
        userMapper1.insertSelective(user);
        //int i = 1/0;
    }
}
