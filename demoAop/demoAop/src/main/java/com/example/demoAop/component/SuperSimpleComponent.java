package com.example.demoAop.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SuperSimpleComponent {

    //Joint point
    public void messageMe(){
        log.info("messageMe() called from SuperSimpleComponent");
    }

    public void printMe(){
        log.info("printMe() called from SuperSimpleComponent");
    }

    public void sayHi(){
        log.info("sayHi() called from SuperSimpleComponent");
    }
}
