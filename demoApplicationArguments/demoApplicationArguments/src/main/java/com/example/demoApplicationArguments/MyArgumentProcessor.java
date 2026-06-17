package com.example.demoApplicationArguments;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@ToString
@Slf4j
public class MyArgumentProcessor {

    private final ApplicationArguments applicationArguments;

    @Autowired
    public MyArgumentProcessor(ApplicationArguments applicationArguments) {
        this.applicationArguments = applicationArguments;
    }

    public void accessArguments() {

        log.info("getOptionNames {}", applicationArguments.getOptionNames());
        log.info("getNonOptionArgs {}", applicationArguments.getNonOptionArgs());
        log.info("getSourceArgs {}", Arrays.stream(applicationArguments.getSourceArgs()).toList());

    }
}
