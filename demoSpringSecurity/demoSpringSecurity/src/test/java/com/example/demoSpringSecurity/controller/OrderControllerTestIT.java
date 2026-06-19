package com.example.demoSpringSecurity.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
class OrderControllerTestIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getShouldFailWithoutAuthentication() {

        ResponseEntity<String> response  = restTemplate.getForEntity("/order/1", String.class);
        assertEquals(401, response.getStatusCode().value());
    }


    @Test
    void getShouldFailWith403() {

        ResponseEntity<String> response  = restTemplate
                .withBasicAuth("admin", "password")
                .getForEntity("/order/1", String.class);
        assertEquals(HttpStatusCode.valueOf(403), response.getStatusCode());
    }

    @Test
    void shouldCreateOrderSuccessfully() {
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json");
        String body = "{\n" +
                " \"details\": \"tv, laptop\",\n" +
                " \"total\": 2000.50\n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<>(body, header);

        ResponseEntity<String> response  = restTemplate
                .withBasicAuth("user", "password")
                .exchange("/order", HttpMethod.POST, entity, String.class);
        assertEquals(201, response.getStatusCode().value());
    }


}