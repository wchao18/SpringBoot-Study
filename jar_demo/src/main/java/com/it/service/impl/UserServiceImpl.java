package com.it.service.impl;

import com.it.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/06/08 19:35
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String say(String name) {
        return name;
    }
}
