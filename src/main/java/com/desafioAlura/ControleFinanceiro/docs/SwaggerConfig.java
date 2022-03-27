package com.desafioAlura.ControleFinanceiro.docs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig extends  WebMvcConfigurationSupport{
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
	
	private Contact contato() {
		return new Contact("Rodrigo Fernandes", "https://www.linkedin.com/in/rodrigo-fernandes-b12b7a169/",
				"rodrigohf79@hotmail.com");
	}

	private ApiInfoBuilder informacoes() {
		ApiInfoBuilder apiInfoBuilder = new  ApiInfoBuilder();
		apiInfoBuilder.title("Spring Boot REST API");
		apiInfoBuilder.description("Criando API de controle financeiro do desafio Alura");
		apiInfoBuilder.version("1.0.0");
		apiInfoBuilder.license("Apache License Version 2.0");
		apiInfoBuilder.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0");
		apiInfoBuilder.contact(this.contato());
		
		return apiInfoBuilder;
	}
	
	private List<ResponseMessage> responseMessageForGET()
	{
	    return new ArrayList<ResponseMessage>() {{
	        add(new ResponseMessageBuilder()
	            .code(500)
	            .message("500 message")
	            .responseModel(new ModelRef("Error"))
	            .build());
	        add(new ResponseMessageBuilder()
	            .code(403)
	            .message("Forbidden!")
	            .build());
	    }};
	}


	@Bean
	public Docket detalheApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		
		docket
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.desafioAlura.ControleFinanceiro.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.informacoes().build())
				.consumes(new HashSet<String>(Arrays.asList("application/json")))
				.produces(new HashSet<String>(Arrays.asList("application/json")))
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, responseMessageForGET());
return docket;
	}

}
