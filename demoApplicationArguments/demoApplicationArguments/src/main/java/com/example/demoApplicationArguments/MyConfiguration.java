package com.example.demoApplicationArguments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@Lazy
public class MyConfiguration {

    @Bean(name = {"simple.bean", "not.so.simple.bean"})
    @Scope("prototype")
    public MyBean myBean(){
        return new MyBean();
    }
    @Bean
    public MyBean myDefaultBean(){
        return new MyBean();
    }
}
