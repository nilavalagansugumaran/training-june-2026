package com.example.demoBeanInit.component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Scope
//@Lazy
public class MyComponent implements InitializingBean {

    public MyComponent() {
        log.info("Constructor...");
    }

    @PostConstruct
    public void init(){
        log.info("PostConstruct...");
    }

    @PreDestroy
    public void destroy(){
        log.info("PreDestroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet...");
    }
}
