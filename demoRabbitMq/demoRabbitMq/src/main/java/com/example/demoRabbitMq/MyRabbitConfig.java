package com.example.demoRabbitMq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRabbitConfig {

    @Bean
    public MessageConverter jacksonJsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }

    @Bean
    Queue queue(){

        return QueueBuilder.durable("example.queue").build();
    }

    @Bean
    Exchange exchange(){

        return ExchangeBuilder.directExchange("example.exchange").build();
    }

    @Bean
    Binding binding(Queue q, Exchange e){
        return BindingBuilder.bind(q).to(e).with("example.routingkey").noargs();
    }
}
