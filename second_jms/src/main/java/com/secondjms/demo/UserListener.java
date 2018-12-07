package com.secondjms.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserListener {

    private final JmsTemplate jmsTemplate;

    public UserListener(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = "user_arrived")
    public void onNewUserArrive(String username) {
        System.out.println("I received " + username);
        this.jmsTemplate.convertAndSend("successful_mail_arrive", username);
    }
}
