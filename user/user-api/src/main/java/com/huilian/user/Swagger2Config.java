package com.huilian.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.huilian.user.controller"))
                .build()
                .directModelSubstitute(Date.class, String.class)
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()//
                .title("测试")// 标题
                .description("测试服务")// 描述
                //			.termsOfServiceUrl("http://www.yinpiao.com")//
//				.contact(new Contact("hzm", "http://www.yinpiao.com", "415168305@qq.com"))// 联系
                //.license("Apache License Version 2.0")// 开源协议
                //.licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")// 地址
                //.version("1.0")// 版本
                .build();
    }
}
