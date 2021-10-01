package br.com.santander.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AgendaApplication {

	//http://localhost:8080/swagger-ui/index.html

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

}
