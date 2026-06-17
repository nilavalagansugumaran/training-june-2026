package com.example.demoApplicationArguments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplicationArgumentsApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoApplicationArgumentsApplication.class, args);
		ctx.getBean(MyArgumentProcessor.class).accessArguments();

		System.out.println(ctx.getBean("simple.bean", MyBean.class).toString());
		System.out.println(ctx.getBean("simple.bean", MyBean.class).hashCode());

		System.out.println(ctx.getBean("not.so.simple.bean", MyBean.class).toString());
		System.out.println(ctx.getBean("not.so.simple.bean", MyBean.class).hashCode());

		System.out.println(ctx.getBean("myDefaultBean", MyBean.class).toString());
		System.out.println(ctx.getBean("myDefaultBean", MyBean.class).hashCode());

		System.out.println(ctx.getBean("myDefaultBean", MyBean.class).toString());
		System.out.println(ctx.getBean("myDefaultBean", MyBean.class).hashCode());

	}

}
