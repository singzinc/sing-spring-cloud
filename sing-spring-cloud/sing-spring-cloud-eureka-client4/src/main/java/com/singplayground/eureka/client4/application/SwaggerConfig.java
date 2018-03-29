package com.singplayground.eureka.client4.application;




import java.util.List;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig<ResponseMessage> {
	
	/*
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()                 
                .apis(RequestHandlerSelectors.basePackage("com.singplayground.eureka.client4.controller"))
                //.paths(regex("/product.*"))
                .build();
        		
        
             
    }
    */
	
	/*
	
	@Bean
    public Docket api() { 
		
		
		List <ResponseMessage> responseMessageList = new ArrayList<ResponseMessage>();
	    responseMessageList
	        .add(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build());
	    responseMessageList.add(new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build());

		
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo())
          ;
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
          "REST API",
          "Some custom description of API.",
          "API TOS",
          "Terms of service",
          "",
          "License of API",
          "API license URL");
        return apiInfo;
    }
    
    */
	
	
	
	
	@Bean
	  public Docket api() {
	    final List<ResponseMessage> responseMessageList = new ArrayList<ResponseMessage>();
	    responseMessageList
	        .add((ResponseMessage) new ResponseMessageBuilder()
	        		.code(500).message("500 message").responseModel(new ModelRef("Error xxx")).build());
	    responseMessageList
	    	.add((ResponseMessage) new ResponseMessageBuilder()
	    			.code(403).message("Forbidden!!!!! xxxxx").build());

	    return new Docket(DocumentationType.SWAGGER_2)
	    		.select()
	    		.apis(RequestHandlerSelectors.basePackage("com.singplayground.eureka.client4.controller"))
	        .paths(PathSelectors.any()).build().apiInfo(apiInfo()).useDefaultResponseMessages(true)
	        .globalResponseMessage(RequestMethod.GET, (List<springfox.documentation.service.ResponseMessage>) responseMessageList)
	        .globalResponseMessage(RequestMethod.POST, (List<springfox.documentation.service.ResponseMessage>) responseMessageList);
	  }

	  private ApiInfo apiInfo() {
	    final Contact contact = new Contact("Sing playground", "our web address", "my email");
	    final ApiInfo apiInfo = new ApiInfo("My REST API", "Some custom description of API.", "API TOS", "Terms of service", contact,
	        "License of API", "API license URL");
	    return apiInfo;
	  }
}
