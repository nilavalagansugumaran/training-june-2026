package com.example.demoRestClient;

import com.example.demoRestClient.client.MyRestClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoRestClientApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoRestClientApplication.class, args);
		MyRestClient myRestClient = ctx.getBean(MyRestClient.class);
		myRestClient.getEmployee();
		myRestClient.getAllEmployees();
		myRestClient.createEmployee();
		myRestClient.updateEmployee();
		myRestClient.deleteEmployee();
	}

}
