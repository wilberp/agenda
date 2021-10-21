package br.com.santander.agenda.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

//	@Bean
//	public KafkaAdmin admin() {
//		Map<String, Object> configs = new HashMap<>();
//		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		return new KafkaAdmin(configs);
//	}

	@Bean
	public NewTopic topic() {
		System.out.println("Passou por aqui");
		return TopicBuilder.name("TOPIC_EMAIL_MARKET").partitions(2).replicas(2).build();
	}
}
