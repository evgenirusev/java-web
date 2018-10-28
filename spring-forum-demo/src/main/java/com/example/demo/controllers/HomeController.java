package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

    @GetMapping(value={"", "/", "home"})
    public ModelAndView home() {
        return this.view("home.html");
    }

    @GetMapping("/test/{id}")
    public ModelAndView test(ModelAndView modelAndView, @PathVariable String id) {
        return this.redirect("/");
    }
}