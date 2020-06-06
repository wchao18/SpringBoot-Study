package com.it.controller;

import com.it.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @description 配置文件测试，
 * @date 2020/06/06 11:46
 */
@RestController
public class ConfigController {

  @Value("${config.test.name}")
  private String configTestName;


    @Value("${test.name}")
    private String testName;

    @Autowired
    private Student student;

    @RequestMapping("/config")
    public String getConfigTestName() {
        return student.toString();
    }



}
