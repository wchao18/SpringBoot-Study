package com.it;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author wangchao
 * @description 测试请求体验证
 * @date 2023/05/06 9:25
 */
@RestController
public class RequestBodyController {

    //@Validated和@Valid都可以的
    @PostMapping("/valid")
    public Object valid(@RequestBody @Validated People people) {
        return "校验成功";
    }
}
