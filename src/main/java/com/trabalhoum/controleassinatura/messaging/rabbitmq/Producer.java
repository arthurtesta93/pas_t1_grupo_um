package com.trabalhoum.controleassinatura.messaging.rabbitmq;

import com.trabalhoum.controleassinatura.application.dto.SubscriptionDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static Logger logger = LogManager.getLogger(Producer.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(SubscriptionDTO dto) {
        logger.info("Enviando mensagem  com a atualização da assinatura: {}", dto);
        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUTEXCHANGENAME, "", dto);
    }

}
