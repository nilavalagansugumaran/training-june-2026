package com.example.demoWeb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MyRestController {

    @RequestMapping(method = RequestMethod.GET, produces = {"text/html"})
    public String sayHello(@RequestParam("name") String name){

        return "Hello "+ name;
    }
}
