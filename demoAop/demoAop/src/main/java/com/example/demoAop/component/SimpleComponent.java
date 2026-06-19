package com.example.demoAop.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SimpleComponent {

    //Joint point
    public void messageMe(){
        log.info("messageMe() called from SimpleComponent");
    }

    public void printMe(){
        log.info("printMe() called from SimpleComponent");
    }

    public void sayHi(){
        log.info("sayHi() called from SimpleComponent");
    }
}
