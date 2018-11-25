package com.rusev.springauth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @GetMapping("/home")
    public ModelAndView adminHome(HttpSession httpSession, ModelAndView modelAndView) {
        modelAndView.addObject("username", httpSession.getAttribute("username"));
        return super.view("admin-home", modelAndView);
    }
}
