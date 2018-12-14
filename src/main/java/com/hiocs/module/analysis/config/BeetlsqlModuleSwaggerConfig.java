package com.hiocs.module.analysis.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootConfiguration
@EnableSwagger2
public class BeetlsqlModuleSwaggerConfig {

    @Bean
    public Docket HOMEPAGE_API(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("首页")
                .apiInfo(apiInfo("首页","1.0",""))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/home/**"))
                .build();
    }

    @Bean
    public Docket SUBJECTVIEW_API(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("学科全景")
                .apiInfo(apiInfo("学科全景","1.0",""))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/subjectview/**"))
                .build();
    }

    @Bean
    public Docket SUBJECTDATA_API(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("学科数据")
                .apiInfo(apiInfo("学科数据","1.0",""))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/subjectdata/**"))
                .build();
    }

    @Bean
    public Docket SUBJECTCOMPARE_API(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("学科对比")
                .apiInfo(apiInfo("学科对比","1.0",""))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/subjectcompare/**"))
                .build();
    }

    @Bean
    public Docket SUBJECTTRENDANALYSIS_API(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("趋势分析")
                .apiInfo(apiInfo("趋势分析","1.0",""))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/subjecttrendanalysis/**"))
                .build();
    }

    private ApiInfo apiInfo(String title,String version,String desc){
        return new ApiInfoBuilder()
                .title(title)
                .version(version)
                .description(desc)
                .build();
    }
}
