package com.example.demoAop;

import com.example.demoAop.component.SimpleComponent;
import com.example.demoAop.component.SuperSimpleComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoAopApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoAopApplication.class, args);
		ctx.getBean(SimpleComponent.class).messageMe();
		ctx.getBean(SimpleComponent.class).printMe();
		ctx.getBean(SimpleComponent.class).sayHi();

		ctx.getBean(SuperSimpleComponent.class).messageMe();
		ctx.getBean(SuperSimpleComponent.class).printMe();
		ctx.getBean(SuperSimpleComponent.class).sayHi();
	}

}
