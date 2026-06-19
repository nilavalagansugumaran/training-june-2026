package com.example.demoActiveMq.components;

import com.example.demoActiveMq.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SenderComponent {

    public void sendStringMessage(String message) {
        log.info("Sending message to activeMQ");

    }

    public void sendEmployeeData(Employee employee) {
        log.info("Sending employee data to activeMQ");

    }
}
