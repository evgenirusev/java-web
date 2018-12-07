package com.firstjms.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final JmsTemplate jmsTemplate;

    @Autowired
    public HomeController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping("/send/{name}")
    public @ResponseBody
    String send(@PathVariable String name) {
        this.jmsTemplate.convertAndSend(
                "user_arrived",
                name
        );
        return "success";
    }
}