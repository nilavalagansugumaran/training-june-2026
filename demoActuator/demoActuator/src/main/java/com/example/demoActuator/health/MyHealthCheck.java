package com.example.demoActuator.health;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("NilaAppHealthCheck")
public class MyHealthCheck implements HealthIndicator {


    @Override
    public @Nullable Health health() {
        // Write customer checks


        return Health.down().build();
    }
}
