package br.com.santander.agenda.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService 
{
	private final Logger logger 
		= LoggerFactory.getLogger(KafkaConsumerService.class);

	/*@KafkaListener(topics = "TOPIC_NAME_TEST", groupId = "group-id")
	public void consume(String mensagem) {
		logger.info(String.format("Mensagem recebida -> %s", mensagem));
	}*/

//	@KafkaListener(topics ="TOPIC_NAME_USER_LOG3", groupId = "group-id2")
//	public void consume(Usuario usuario) {
//		logger.info(String.format("Usuario criado -> %s", usuario));
//	}
}