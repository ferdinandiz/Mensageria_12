package com.mensageria.mensageria_12;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {

    @RabbitListener(queues = "${queue.name}", ackMode = "MANUAL")
    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        try {
            System.err.println("Consumindo: "+message);
            Thread.sleep(100);
            channel.basicAck(tag,false);
        } catch (Exception e) {
            channel.basicNack(tag,false,true);
        }
    }

}
