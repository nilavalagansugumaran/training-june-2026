package com.example.demoConfigProps.configuration;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "contact")
@Data
@ToString
@Configuration
public class ContactConfiguration {

    private String name;
    private String email;
    private Address address;

    @Data
    @ToString
    public static class Address {

        private String postcode;
    }
}
