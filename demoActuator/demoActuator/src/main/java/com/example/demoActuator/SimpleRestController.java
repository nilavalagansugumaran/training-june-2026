package com.example.demoActuator;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SimpleRestController {

    private Counter helloCounter;
    private MeterRegistry meterRegistry;

    @Autowired
    public SimpleRestController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.helloCounter = Counter.builder("hello.counter")
                .description("This is the counter for hello")
                .register(meterRegistry);
    }

    @Timed(
            value = "hello.timer",
            description = "Time to check hello availability",
            percentiles = {0.5, 0.95, 0.99},
            histogram = true
    )
    @RequestMapping(method = RequestMethod.GET, produces = {"text/html"})
    public String sayHello(){
        helloCounter.increment();
        return "Hello!";
    }
}
