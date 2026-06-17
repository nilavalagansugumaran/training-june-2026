package com.example.demoBeans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demoBeans.component.*;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class DemoBeansApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoBeansApplication.class, args);

		MyBean mb = ctx.getBean(MyBean.class);
		System.out.println(mb);
		System.out.println(mb.hashCode());
		//log.info("My Bean {}", mb);

		MyBean mb1 = ctx.getBean(MyBean.class);
		System.out.println(mb1);
		System.out.println(mb1.hashCode());
		//log.info("My Bean {}", mb);


		SimpleBean smb = ctx.getBean(SimpleBean.class);
		System.out.println(smb);
		System.out.println(smb.hashCode());
		//log.info("My SimpleBean {}", smb);
		SimpleBean smb1 = ctx.getBean(SimpleBean.class);
		System.out.println(smb1);
		System.out.println(smb1.hashCode());
	}

}
