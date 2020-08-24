package com.xzm.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * http://localhost:8000/swagger-ui.html休息休息
 * http://localhost:8000/doc.html1221
 */

@Configuration
@EnableSwagger2
@Profile({"dev","test"})
public class SwaggerConfig {

    //    @Value("${jwt.header}")
//    private String tokenHeader;
//    @Value("${swagger.enabled}")
//    private Boolean enabled;
//    @Autowired
//    private Environment environment;
//    @Value("${server.port}")
//    private int serverPort;
//    @Value("${spring.application.name}")
//    private String serverName;
    /*----------------------------------------------------------------------------*/
    @Autowired
    private Environment environment;

    private ApiInfo apiInfo() {
        String name = "jenkins-maven-demo";
        String javabackendName = environment.getProperty("javabackend.name");
        return new ApiInfoBuilder()
                .title(name + "服务")
                .description(javabackendName + "接口Api文档")
                .build();
    }

    @Bean
    public Docket creatApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
}
