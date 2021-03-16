package com.it;

import com.it.dto.AddDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/16 14:05
 */
@RestController
public class TestController {

    @RequestMapping("/add")
    public String add(@Valid AddDto addDto, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                throw new Exception(allError.getDefaultMessage());
            }
        }
        return addDto.toString();
    }
}
