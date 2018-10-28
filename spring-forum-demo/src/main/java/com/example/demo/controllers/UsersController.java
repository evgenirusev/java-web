package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.models.binding.CreateUserBindingModel;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController extends BaseController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView createUser() {
        return super.view("users/register");
    }

    @PostMapping("/register")
    public ModelAndView saveUser(CreateUserBindingModel createUserBindingModel, ModelAndView model) {
        this.userService.saveUser(createUserBindingModel);
        model.addObject("username", createUserBindingModel.getUsername());
        return super.view("users/success", model);
    }

    @GetMapping("/all")
    public ModelAndView allUsers(ModelAndView modelAndView) {
        List<User> users = this.userService.getUsers();
        modelAndView.addObject("users", users);
        return super.view("users/users-all", modelAndView);
    }
}