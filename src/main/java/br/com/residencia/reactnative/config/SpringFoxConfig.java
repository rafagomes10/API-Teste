package br.com.residencia.reactnative.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig extends WebMvcConfigurerAdapter {

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
	
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/docApi/v2/api-docs", "/v2/api-docs");
//        registry.addRedirectViewController("/docApi/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
//        registry.addRedirectViewController("/docApi/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
//        registry.addRedirectViewController("/docApi/swagger-resources", "/swagger-resources");
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/docApi/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
//        registry.addResourceHandler("/docApi/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
    
//	private ApiInfo apiInfo() {
//		ApiInfo apiInfo = ApiInfoBuilder()
//				.title("Documentção da API")
//				.description("Ecommerce React Native")
//				.license("Apache License Version 2.0")
//				.version("2.0.0")
//				.build();
//		return apiInfo;
//	}
	
}
