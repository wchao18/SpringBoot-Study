package com.it.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.dao.domain.User;
import com.it.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangchao
 * @description mybatis的测试
 * @date 2019/08/18 20:09
 */

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/add")
    @Transactional  //启动类上不加@EnableTransactionManagement也是可以的
    public Long addUser(@RequestBody User user){
        userMapper.insertSelective(user);
        //int i = 1/0;
        return user.getId();
    }

    @GetMapping("/users")
    public PageInfo<User> getUsers(){
        //为了测试快，虽然代码有点不规范
        PageHelper.startPage(-99,10);
        List<User> list = userMapper.selectList();
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}
