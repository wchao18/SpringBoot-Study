package com.it;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author wangchao
 * @description 手动验证
 * @date 2023/05/06 9:25
 */
@RestController
public class ManualValidController {

    @Autowired
    private Validator validator;

    @PostMapping("/manual-valid")
    public Object valid(@RequestBody People people) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        //validator可以替换为spring bean注入
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<People>> constraintViolations = validator.validate(people);
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            throw new RuntimeException(constraintViolations.iterator().next().getMessage());
        }
        return "校验成功";
    }
}
