package com.rusev.springauth.controllers;

import com.rusev.springauth.models.binding.UserRegisterBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    @GetMapping("/register")
    public ModelAndView register() {
        return super.view("register");
    }

    @PostMapping("/register")
    public ModelAndView storeRegister(@ModelAttribute UserRegisterBindingModel userRegisterBindingModel) {

        return null;
    }
}
