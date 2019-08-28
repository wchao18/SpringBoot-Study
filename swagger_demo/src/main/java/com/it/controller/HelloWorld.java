package com.it.controller;

import com.it.pojo.User;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

@Controller
@Api(description = "swagger的测试类")
public class HelloWorld {

    @ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value = "查询接口", notes = "测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "int", required = true, paramType = "query")
    })
    public Map<String, Object> sayHelloWorld(@RequestParam(value = "name", required = true) String name,
                                             @RequestParam(value = "age", required = true) Integer age) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", name);
        hashMap.put("age", age);
        return hashMap;
    }


    @ResponseBody
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户信息", notes = "测试接口")
    public User save(User user) {
        return user;
    }


    @ResponseBody
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "根据主键ID查询用户信息", notes = "根主键ID查询用户信息")
    @ApiImplicitParam(name = "id", value = "主键ID", required = true, dataType = "Long", paramType = "path")
    public User getUser(@PathVariable(value = "id") Long id) {
        User user = new User();
        user.setId(id);
        user.setAge(26);
        user.setName("小王");
        user.setAddress("浙江杭州");
        return user;
    }

    /**
     * 测试一下ApiParam注解
     */
    @RequestMapping(value = "/apiParam", method = RequestMethod.GET)
    public User getUser(@ApiParam(name = "name", value = "用户名", required = true) @RequestParam(value = "name") String name,
                        @ApiParam(name = "age", value = "年龄", required = true) @RequestParam(value = "age") Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }


    @ApiIgnore //忽略某类/方法/参数的文档，不能用在实体类上面
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success() {
        return "success";
    }

}
