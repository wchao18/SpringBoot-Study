package com.it.dao.domain;

import java.io.Serializable;


public class User implements Serializable {

    private static final long serialVersionUID = -8154351343001580266L;
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 用户年龄
     */
    private Integer age;

    private Integer gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}