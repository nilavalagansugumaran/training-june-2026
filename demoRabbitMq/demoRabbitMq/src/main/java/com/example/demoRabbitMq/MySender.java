package com.example.demoRabbitMq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySender {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MySender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Employee e) {

        rabbitTemplate.convertAndSend("example.exchange", "example.routingkey", e, (m) -> {
            m.getMessageProperties().setHeader("myHeader", "Header Value");
            return m;
        });
    }
}
