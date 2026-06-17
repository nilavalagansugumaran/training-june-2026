package com.example.demoActuator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SimpleRestController {

    @RequestMapping(method = RequestMethod.GET, produces = {"text/html"})
    public String sayHello(){

        return "Hello!";
    }
}
