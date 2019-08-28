package com.it.pojo;

import java.io.Serializable;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/21 14:49
 */
public class User implements Serializable {

    private static final long serialVersionUID = 8615514215268093842L;

    private String name;

    private Integer age;

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
