package br.com.feltex.citacoesweb;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(title = "Api de Citações", version = "3.0.1", description = "API do Canal Feltex"),
		servers = {
				@Server(url = "http://localhost:8080"),
				@Server(url = "http://www.feltex.com.br/citacoes-web"),
		}
)
public class CitacoesWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitacoesWebApplication.class, args);
	}

}
