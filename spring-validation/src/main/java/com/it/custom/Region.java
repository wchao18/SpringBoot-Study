package com.it.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author wangchao
 * @description TODO
 * @date 2023/05/06 10:50
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = CustomValidator.class)
public @interface Region {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Region 值不在可选范围内";
}