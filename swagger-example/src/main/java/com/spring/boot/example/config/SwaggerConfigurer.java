package com.spring.boot.example.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger的配置类
 *
 * @author huaijin
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigurer {

    private static final String BASE_PACKAGE = "com.spring.boot.example.controller";
    private static final String TITLE = "Swagger-Example测试API";
    private static final String DESCRIPTION = "swagger神器";
    private static final String SERVICE_URL = "http://localhost:8080/swagger";
    private static final String VERSION = "1.0.0";

    @Bean
    public Docket createFinRiskApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .termsOfServiceUrl(SERVICE_URL)
                .version(VERSION)
                .build();
    }
}
