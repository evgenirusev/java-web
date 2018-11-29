package com.example.demo.controllers;

import com.example.demo.model.view.UserRegisterRequestModel;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/register")
    public ModelAndView register() {
        return new ModelAndView("users/register.html");
    }

    @PostMapping("users/register")
    public ModelAndView register(UserRegisterRequestModel model) {
        this.userService.register(model);

        return new ModelAndView("redirect:/login");
    }
}
