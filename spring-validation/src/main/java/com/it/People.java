package com.it;

import com.it.custom.Region;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wangchao
 * @description TODO
 * @date 2023/05/06 9:21
 */
@Data
public class People {

    @NotBlank(message = "name不能为空")
    private String name;

    @Min(value = 18,message = "年龄必须大于18周岁")
    @NotNull
    private Integer age;

    @Region
    private String address;

}
