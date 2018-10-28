package com.example.demo.controllers;

import com.example.demo.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class HomeController extends BaseController {

    @GetMapping(value={"", "/", "home"})
    public ModelAndView home() {
        return this.view("home.html");
    }

    @GetMapping("/test")
    public ModelAndView test() {
        User user = new User("Evgeni", "Gmail@gmail.gmail");
        user.setId("1");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("test");
        modelAndView.addObject("obj", user);
        return  modelAndView;
    }
}