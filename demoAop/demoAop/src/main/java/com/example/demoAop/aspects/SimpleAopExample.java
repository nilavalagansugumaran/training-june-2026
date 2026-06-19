package com.example.demoAop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SimpleAopExample {

    public void handleAllMessages() {

        log.info("AOP in action for all messages....");
    }
}
