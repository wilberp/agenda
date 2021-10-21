package br.com.santander.agenda.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	private static final Logger logger = 
			LoggerFactory.getLogger(KafkaProducerService.class);
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public void enviaMensagem(String mensagem) 
	{
		logger.info(String.format("Mensagem enviada -> %s", mensagem));
		this.kafkaTemplate.send("TOPIC_EMAIL_MARKET", mensagem);
	}
	
//	public void criaLogUsuario(Usuario usuario)
//	{
//		logger.info(String.format("Usuario criado -> %s", usuario));
//		this.kafkaTemplate.send("TOPIC_NAME_USER_LOG3", usuario.getCpf(), usuario);
//	}
}
