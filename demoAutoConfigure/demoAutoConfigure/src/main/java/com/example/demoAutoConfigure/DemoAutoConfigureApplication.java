package com.example.demoAutoConfigure;

import com.example.demoAutoConfigure.component.MyAutoConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoAutoConfigureApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoAutoConfigureApplication.class, args);

		System.out.println(ctx.getBean(MyAutoConfigBean.class));
	}

}
