package com.example.demoRabbitMq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyReceiver {

    @RabbitListener(queues = "example.queue")
    public void receive(@Payload Employee e, @Headers MessageHeaders headers) {

        log.info("Employee {}", e);
        log.info("Headers {}", headers.entrySet());
    }
}
