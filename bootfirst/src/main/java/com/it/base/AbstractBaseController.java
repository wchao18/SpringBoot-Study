package com.it.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/15 18:00
 */

public abstract class AbstractBaseController {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String key,String ...args) {
        return messageSource.getMessage(key,args, Locale.getDefault());
    }
}
