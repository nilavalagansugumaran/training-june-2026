package com.example.demoRestClient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class MyRestClient {


    private RestClient restClient;

    public MyRestClient( ) {
        this.restClient = RestClient.create();

    }

    public void createEmployee(){
        String response = restClient.post()
                .uri("http://localhost:8080/employee")
                .contentType(APPLICATION_JSON)
                .body("{\"id\":123,\"name\":\"Nila1\",\"email\":\"nila@nila.com\",\"salary\":20000.0}")
                .retrieve()
                .body(String.class);
        System.out.println(response);
    }
    public void updateEmployee(){

        ResponseEntity<Void> response = restClient.put()
                .uri("http://localhost:8080/employee/123")
                .contentType(APPLICATION_JSON)
                .body("{\"id\":123,\"name\":\"Nila1\",\"email\":\"nila@nila.com\",\"salary\":20000.0}")
                .retrieve()
                .toBodilessEntity();
        System.out.println(response.getStatusCode());
    }
    public void deleteEmployee(){
        ResponseEntity<Void> response = restClient.delete()
                .uri("http://localhost:8080/employee/123")
                .retrieve()
                .toBodilessEntity();
        System.out.println(response.getStatusCode());
    }
    public void getEmployee(){

        System.out.println(restClient.get().uri("http://localhost:8080/employee?id=123")
                .retrieve().body(String.class));
    }
    public void getAllEmployees(){
        System.out.println(restClient.get().uri("http://localhost:8080/employee/all")
                .retrieve().body(String.class));
    }

}
