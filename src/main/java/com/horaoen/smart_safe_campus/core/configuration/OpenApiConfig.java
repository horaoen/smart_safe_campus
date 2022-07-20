package com.horaoen.smart_safe_campus.core.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author horaoen
 */
@Configuration
@ConfigurationProperties(prefix = "swagger")
@PropertySource(value = "classpath:config/swagger.properties")
public class OpenApiConfig {
    private Info info;
    private ExternalDocumentation externalDocumentation;

    public OpenApiConfig(Info info, ExternalDocumentation externalDocumentation) {
        this.info = info;
        this.externalDocumentation = externalDocumentation;
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(info)
                .externalDocs(externalDocumentation);
    }
}