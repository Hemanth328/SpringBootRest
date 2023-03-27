package com.org.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerApiDocConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2) //Swagger UI Type
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.org.rest")) // to specify base package of RestController
				.paths(PathSelectors.regex("/actor.*")) //global path
				.build()
				.useDefaultResponseMessages(true)
				.apiInfo(createAPIInfo());
	}
	
	// helper method
	private ApiInfo createAPIInfo() {
		Contact contact = new Contact("Hemanth", "https://www.nareshit.com/SPRest", "reddy.hemanthkumar99@gmail.com");
		return new ApiInfo("Actor-API DOC1",
				           "API Info Actor API",
				           "3.0.5.RELEASE",
				           "https://www.nareshit.com/licenseurl",
				           contact,
				           "GNU Public",
				           "http://www.license.com",
				           Collections.emptyList());
	}
	
}
