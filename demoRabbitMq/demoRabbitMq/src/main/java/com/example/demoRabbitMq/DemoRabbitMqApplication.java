package com.example.demoRabbitMq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoRabbitMqApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoRabbitMqApplication.class, args);

		ctx.getBean(MySender.class).send(Employee.builder().name("Nila").age(201).build());
	}

}
