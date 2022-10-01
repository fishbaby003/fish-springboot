//package com.fish.minio.config;
//
//import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//@EnableKnife4j
//public class Knife4jConfiguration {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .useDefaultResponseMessages(false)
//                .apiInfo(apiInfo())
//                .select()                .apis(RequestHandlerSelectors.basePackage("com.fish.minio.controller"))
//                .paths(PathSelectors.any())
//                .build();
//
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .description("Kinfe4j 集成测试文档")
//                .contact(new Contact("fish", "https://www.toutiao.com/c/user/token/MS4wLjABAAAApJyWoDllDsOZojggLObCblRRqKmUzto4_jHLfM5Da7A/?source=tuwen_detail&log_from=f4b96b06c9fe_1659793089934", "fish@qq.com"))
//                .version("v1.1.0")
//                .title("API测试文档")
//                .build();
//    }
//
//}
//
