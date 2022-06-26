package com.chen.chenwen.controller;

import com.chen.chenwen.common.util.RedisUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/test")
@Api(tags = "测试模块controller的api")
@ApiModel("ApiModel")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("say")
    @ApiOperation(value = "接口say hello接口")
    public String say() {
        System.out.println("hello");
        return "hello";
    }

    @GetMapping("testRedis")
    @ApiOperation(value = "测试redis工具类接口")
    public String test1() {
        String result = "";
        redisUtil.set("fanjic","chenwen");
        result = (String) redisUtil.get("fanjic");
        System.out.println(result);
        return result;
    }

    @GetMapping("testLog")
    @ApiOperation("测试log日志生成api")
    public String testLog() {

        logger.debug("=====>测试日志debug级别打印<====");
        logger.info("=====>测试日志info级别打印<=====");
        logger.error("=====>测试日志error级别打印<====");
        logger.warn("=====>测试日志warn级别打印<=====");

        String csdn = "https://ethereum.blog.csdn.net/article/details/104977666";
        logger.info("这篇博客的访问地址：{}",csdn);
        return "测试log日志生成api";
    }

    @GetMapping("doSign")
    @ApiOperation(value = "图片合成pdf（签字）")
    public void doSign() {


    }


}
