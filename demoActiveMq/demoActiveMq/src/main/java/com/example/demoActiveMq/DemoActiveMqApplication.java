package com.example.demoActiveMq;

import com.example.demoActiveMq.components.SenderComponent;
import com.example.demoActiveMq.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class DemoActiveMqApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoActiveMqApplication.class, args);

		ctx.getBean(SenderComponent.class).sendStringMessage("Hi from MARS!");
		ctx.getBean(SenderComponent.class).sendEmployeeData(Employee.builder()
				.name("Nila").email("test@test.com").build());

	}

}
