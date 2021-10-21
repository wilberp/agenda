package br.com.santander.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableKafka
public class AgendaApplication {

	//https://microservices.io/
	//http://localhost:8080/swagger-ui/index.html
    //https://www.ti-enxame.com/pt/windows/existe-uma-maneira-facil-de-instalar-o-kafka-no-windows/1046246697/

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}
	//https://devcenter.heroku.com/articles/customizing-the-jdk
}
