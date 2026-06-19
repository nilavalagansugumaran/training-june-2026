package com.example.demoActiveMq.components;

import com.example.demoActiveMq.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiverComponent {

    @JmsListener(destination = "DestinationForStringMessage")
    public void receiveStringData(String message) {

        log.info("Received message from sender. Message = {}", message);
    }

    @JmsListener(destination = "DestinationForEmployeeData")
    public void receiveEmployeeData(Employee employee) {

        log.info("Received Employee data from sender. Message = {}", employee);
    }
}
