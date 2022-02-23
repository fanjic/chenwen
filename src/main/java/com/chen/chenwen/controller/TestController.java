package com.chen.chenwen.controller;

import com.chen.chenwen.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = "测试模块controller的api")
@ApiModel("ApiModel")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("say")
    @ApiOperation(value = "接口say hello接口")
    public String say() {
        System.out.println("hello");
        return "hello";
    }

    @GetMapping("test1")
    @ApiOperation(value = "测试redis类接口")
    public String test1() {
        String result = "";
        redisUtil.set("fanjic","chenwen");
        result = (String) redisUtil.get("fanjic");
        System.out.println(result);
        return result;
    }
}
