package com.br.mobiauto.management.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("titulo teste")
                        .description("description")
                        .version("1.0")
                        .termsOfService("http://termos teste")
                        .summary("summary")
                        .license(new License()
                                .name("MIT")));
    }
}
