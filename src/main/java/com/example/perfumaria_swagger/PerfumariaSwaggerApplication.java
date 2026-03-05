package com.example.perfumaria_swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "API Perfumaria",
        version = "1.0.0",
        description = "API de gerenciamento de produtos de perfumaria. Contrato técnico para integração de equipes.",
        contact = @Contact(
            name = "Time de Desenvolvimento",
            email = "desenvolvimento@perfumaria.com"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html"
        )
    ),
    servers = {
        @Server(url = "http://localhost:8080", description = "Servidor de Desenvolvimento")
    }
)
public class PerfumariaSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfumariaSwaggerApplication.class, args);
	}

}
