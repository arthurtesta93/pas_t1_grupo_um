package com.trabalhoum.controleassinatura.core.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public GroupedOpenApi api1() {
        return GroupedOpenApi.builder()
                .group("auth-api-1.0")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customizeOpenAPI() {
        final String securitySchemeName = "controleassinatura";
        return new OpenAPI()
                .info(new Info()
                        .title("Spring API")
                        .description("Aplicação de controle de assinaturas.")
                        .version("v1")
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Spring Api Repo")
                        .url("https://github.com/arthurtesta93/pas_t1_grupo_um")
                );
    }
}
