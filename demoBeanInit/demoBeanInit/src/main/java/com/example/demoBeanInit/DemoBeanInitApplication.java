package com.example.demoBeanInit;

import com.example.demoBeanInit.component.MyBean;
import com.example.demoBeanInit.component.MyComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoBeanInitApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoBeanInitApplication.class, args);

//		System.out.println(ctx.getBean(MyComponent.class).toString());
//		System.out.println(ctx.getBean(MyComponent.class).hashCode());
//
//		MyComponent cmp1 = ctx.getBean(MyComponent.class);
//		System.out.println(cmp1.toString());
//		System.out.println(cmp1.hashCode());
//
//		MyComponent cmp2 = ctx.getBean(MyComponent.class);
//		System.out.println(cmp2.toString());
//		System.out.println(cmp2.hashCode());

		System.out.println(ctx.getBean(MyBean.class).toString());
	}

}
