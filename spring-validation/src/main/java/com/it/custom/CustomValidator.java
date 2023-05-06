package com.it.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangchao
 * @description TODO
 * @date 2023/05/06 10:49
 */
public class CustomValidator implements ConstraintValidator<Region, String> {

    @Override
    public void initialize(Region constraintAnnotation) {
        //initialize() 方法用于初始化验证器，这里没有任何初始化逻辑，因此留空即可。
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        List<Object> values = new ArrayList<>();
        values.add("1");
        values.add("2");
        values.add("3");
        if (!values.contains(value)) {
            return false;
        }
        return true;
    }
}
