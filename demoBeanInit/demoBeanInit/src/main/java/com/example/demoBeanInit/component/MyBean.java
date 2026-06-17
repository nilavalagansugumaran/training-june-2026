package com.example.demoBeanInit.component;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@ToString
@Data
public class MyBean {

    @Value("${app.name}")
    private String name;
    @Value("${app.age:100}")
    private int age;
}
