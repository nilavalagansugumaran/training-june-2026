package com.example.demoConfigProps;

import com.example.demoConfigProps.component.ContactComponent;
import com.example.demoConfigProps.configuration.ContactConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
public class DemoConfigPropsApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoConfigPropsApplication.class, args);
		System.out.println(ctx.getBean(ContactComponent.class));
		System.out.println(ctx.getBean(ContactConfiguration.class));
	}

}
