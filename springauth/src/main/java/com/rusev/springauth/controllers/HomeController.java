package com.rusev.springauth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController extends BaseController {
    @GetMapping("/")
    public ModelAndView home() {
        return super.view("home");
    }

    @GetMapping("/home")
    public ModelAndView userHome(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.addObject("username", httpSession.getAttribute("username"));
        return super.view("user-home", modelAndView);
    }
}