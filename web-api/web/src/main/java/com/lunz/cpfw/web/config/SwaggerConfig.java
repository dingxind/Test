package com.lunz.cpfw.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ConditionalOnProperty(prefix = "swagger", value = { "enable" }, havingValue = "true")
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        List<Parameter> params = new ArrayList<Parameter>();

        // ClientId Header parameter
        ParameterBuilder clientParam = new ParameterBuilder();
        clientParam.name("ClientId").description("客户ID").modelRef(new ModelRef("string")).parameterType("header")
                //.required(true)
                .build();
        params.add(clientParam.build());

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 包下的类，才生成接口文档
                // .apis(RequestHandlerSelectors.basePackage("com.lunz.frb.api.controller"))
                // .apis(RequestHandlerSelectors.basePackage("com.cnadmart.modules.*.controller"))
                .paths(PathSelectors.any()).build().globalOperationParameters(params);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("CPFW").description("CPFW-Api接口文档").termsOfServiceUrl("api/swagger-ui.html")
                .version("1.0.0").build();
    }

}