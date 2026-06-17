package com.example.demoConfigProps.component;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class ContactComponent {

    @Value("${contact.name}")
    private String name;
    @Value("${contact.email}")
    private String email;
    @Value("${contact.address.postcode}")
    private String postcode;
}
