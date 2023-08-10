
package com.example.demo;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 *
 * @author davitv
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI publicApi() {
        return new OpenAPI()
                .servers(Collections.singletonList(new Server().url("/")))
                .info(new Info().title("app")
                        .description("main API")
                        .version("2.0"));
    }

}