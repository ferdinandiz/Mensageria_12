package com.mensageria.mensageria_12;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private final RabbitTemplate rabbitTemplate;
    private final String queueName;

    public Producer(RabbitTemplate rabbitTemplate, @Value("${queue.name}") String queueName) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueName = queueName;
    }

    public void sendMassiveMessages() {
        for (int i = 1; i < 1000; i++) {
            String message = "Mensagem " + i;
            rabbitTemplate.convertAndSend(queueName, message);
            System.out.println("Enviada: " + message);
        }
    }
}
