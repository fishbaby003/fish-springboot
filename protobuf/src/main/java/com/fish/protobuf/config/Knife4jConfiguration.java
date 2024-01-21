package com.fish.protobuf.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fish
 */
@Slf4j
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Knife4jConfiguration {

    @Bean
    public Docket createRestApi() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fish.protobuf.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;

    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo=new ApiInfoBuilder()
                .description("SpringBoot - proto buf 使用详解")
                .contact(new Contact("fish", "https://bodyfish.gitee.io/fish-doc/#/", "157309341@qq.com"))
                .version("1.0.0")
                .title("SpringBoot - proto buf 使用详解")
                .build();
        return apiInfo;
    }

}