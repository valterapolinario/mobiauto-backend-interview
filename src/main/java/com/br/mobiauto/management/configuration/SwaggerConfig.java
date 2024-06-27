package com.br.mobiauto.management.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
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
                        .title(" Sistema Gestão facil")
                        .description("Sistema para gestao de revenda de veiculos")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Valter Apolinario")
                                .email("valter_123@hotmail.com")
                                .url("https://www.linkedin.com/in/valter-apolinario-156196150/"))
                        .termsOfService("http://termos teste")
                        .summary("Resolucao de desafio para Desenvolvedor Back-end para empresa mobiauto")
                        .license(new License()
                                .name("MIT")));
    }
}
