package com.example.demoRestClient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;

@Component
public class MyRestClient {


    private RestClient restClient;

    public MyRestClient( ) {
        this.restClient = RestClient.create();

    }

    public void createEmployee(){}
    public void updateEmployee(){}
    public void deleteEmployee(){}
    public void getEmployee(){


    }
    public void getAllEmployees(){
        System.out.println(restClient.get().uri("http://localhost:8080/employee/all")
                .retrieve().body(String.class));
    }

}
