package com.example.demoAop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class SimpleAopExample {

    //advice type
    @Before("execution(void com.example.demoAop.component.*.message*())") // pointcut
    public void handleAllMessages(JoinPoint jp) {

        //advice
        log.info("AOP in action for all messages.... {}", jp.getSignature());
    }
}
