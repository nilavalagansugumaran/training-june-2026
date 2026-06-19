package com.example.demoActiveMq.components;

import com.example.demoActiveMq.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiverComponent {

    public void receiveStringData(String message) {

        log.info("Received message from sender. Message = {}", message);
    }

    public void receiveEmployeeData(Employee employee) {

        log.info("Received Employee data from sender. Message = {}", employee);
    }
}
