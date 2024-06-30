package com.trabalhoum.controleassinatura.messaging.rabbitmq;

import java.util.concurrent.CountDownLatch;

import com.trabalhoum.controleassinatura.application.dto.SubscriptionDTO;
import com.trabalhoum.controleassinatura.application.dto.SubscriptionStatusRequestDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public static final String QUEUENAME = "conversions.v1.conversion-request.save-history";
    private static Logger logger = LogManager.getLogger(Receiver.class);

    @RabbitListener(queues = "#{RabbitMQConfig.getQueueName()}")
    public void receive(SubscriptionStatusRequestDTO dto) {
        logger.info("Mensagem recebida com a atualização da assinatura: {}", dto);
    }


}