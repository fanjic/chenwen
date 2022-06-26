package com.chen.chenwen.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2Config {
    /*Api：修饰整个类，描述Controller的作用
   ApiOperation：描述一个类的一个方法，或者说一个接口
   ApiParam：单个参数描述
   ApiModel：用对象来接收参数
   ApiProperty：用对象接收参数时，描述对象的一个字段
   ApiResponse：HTTP响应其中1个描述
   ApiResponses：HTTP响应整体描述
   ApiIgnore：使用该注解忽略这个API
   ApiError ：发生错误返回的信息
   ApiImplicitParam：一个请求参数
   ApiImplicitParams：多个请求参数*/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //这里一定要标注你控制器的位置
                .apis(RequestHandlerSelectors.basePackage("com.chen.chenwen.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API接口测试")
                .description("创建人：范小城,风格：RestFul,原始地址：swagger-bootstrap-ui")
                .termsOfServiceUrl("http://localhost:8882/doc.html")
                .build();
    }
}
