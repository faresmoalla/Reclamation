package tn.reclamation.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	 @Bean
	   public Docket api() {
	   return new Docket(DocumentationType.SWAGGER_2)
	   .select()
	   .apis(RequestHandlerSelectors.any())
	   .paths(PathSelectors.any())
	   .apis(RequestHandlerSelectors.basePackage("tn.food"))
	   .build();
	   }
	 private ApiInfo apiInfo () {
		 return new ApiInfoBuilder()
		 .title("Swagger Configuration for FOOD APPLICATION")
		 .description("\"Spring Boot Swagger configuration\"")
		 .version("1.1.0").build();
		 }
	 
	 
}
