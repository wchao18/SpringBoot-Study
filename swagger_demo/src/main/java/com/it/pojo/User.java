package com.it.pojo;

import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;

/**
 * @author wang
 * @create 2018-09-21 11:56
 */
public class User implements  Serializable {


    private static final long serialVersionUID = -5948724225441574752L;

    @ApiModelProperty(hidden = true)
    private Long id ;

    @ApiModelProperty(value = "用户名")
    private String name ;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    /**
     * 参数不对外显示，返回结果还是显示的
     */
    @ApiModelProperty(hidden = true)
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
