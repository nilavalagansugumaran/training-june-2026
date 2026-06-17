package com.example.demoApplicationArguments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplicationArgumentsApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoApplicationArgumentsApplication.class, args);
		ctx.getBean(MyArgumentProcessor.class).accessArguments();
	}

}
