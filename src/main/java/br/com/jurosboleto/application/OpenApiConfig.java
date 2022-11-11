package br.com.jurosboleto.application;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Juros Boleto")
                        .description("API para calcular juros e de um boleto vencido")
                        .contact(new Contact().name("Luan Rocha").email("luanbam@hotmail.com"))
                        .version("1.0.0"));
    }
}
