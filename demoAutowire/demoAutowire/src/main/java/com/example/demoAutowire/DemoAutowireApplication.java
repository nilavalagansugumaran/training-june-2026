package com.example.demoAutowire;

import com.example.demoAutowire.service.BankService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoAutowireApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoAutowireApplication.class, args);

		ctx.getBean(BankService.class).deposit(1234, 200.5);
		ctx.getBean(BankService.class).withdraw(1234, 100.5);
		ctx.getBean(BankService.class).transfer(1234, 567, 50.5);
	}

}
