package com.adverts.scanner.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {

  @Bean
  public Docket swaggerConfiguration() {

    final List<ResponseMessage> globalResponses = Arrays.asList(
        new ResponseMessageBuilder()
            .code(400)
            .message("Invalid request parameter(s)")
            .build(),
        new ResponseMessageBuilder()
            .code(405)
            .message("Method Not Allowed")
            .build(),
        new ResponseMessageBuilder()
            .code(500)
            .message("Internal server error")
            .build()
    );

    return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .globalResponseMessage(RequestMethod.GET, globalResponses)
        .globalResponseMessage(RequestMethod.POST, globalResponses)
        .globalResponseMessage(RequestMethod.DELETE, globalResponses)
        .globalResponseMessage(RequestMethod.PATCH, globalResponses)
        .globalResponseMessage(RequestMethod.PUT, globalResponses)
        .produces(Collections.singleton("application/json"))
        .consumes(Collections.singleton("application/json"))
        .apiInfo(metaData());
  }

  private ApiInfo metaData() {
    return new ApiInfoBuilder()
        .title("Adverts Shops scanner API documentation")
        .version("0.1")
        .contact(new Contact("Vjekoslav Krainovic", "", "vjekokr@hotmail.com"))
        .build();
  }

}