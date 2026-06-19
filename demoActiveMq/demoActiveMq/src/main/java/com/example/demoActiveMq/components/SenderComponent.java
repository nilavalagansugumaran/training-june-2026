package com.example.demoActiveMq.components;

import com.example.demoActiveMq.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SenderComponent {

    private JmsTemplate jmsTemplate;

    @Autowired
    public SenderComponent(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendStringMessage(String message) {
        log.info("Sending message to activeMQ");
        jmsTemplate.convertAndSend("DestinationForStringMessage", message);

    }

    public void sendEmployeeData(Employee employee) {
        log.info("Sending employee data to activeMQ");
        jmsTemplate.convertAndSend("DestinationForEmployeeData", employee);

    }
}
