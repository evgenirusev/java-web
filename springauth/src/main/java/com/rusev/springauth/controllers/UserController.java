package com.rusev.springauth.controllers;

import com.rusev.springauth.entities.enums.UserRole;
import com.rusev.springauth.models.binding.UserLoginBindingModel;
import com.rusev.springauth.models.binding.UserRegisterBindingModel;
import com.rusev.springauth.models.service.UserServiceModel;
import com.rusev.springauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return super.view("register");
    }

    @PostMapping("/register")
    public ModelAndView storeRegister(@ModelAttribute UserRegisterBindingModel userRegisterBindingModel) {
        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            // TODO: implement appropriate validation
            return super.view("register");
        }

        this.userService.saveUser(userRegisterBindingModel);
        return super.redirect("/users/login");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return super.view("login");
    }

    @PostMapping("/login")
    public ModelAndView loginConfirm(@ModelAttribute UserLoginBindingModel userLoginBindingModel,
                                     HttpSession httpSession) {
        UserServiceModel userServiceModel = this.userService.getUserByUsername(userLoginBindingModel.getUsername());
        if (userServiceModel == null || !userLoginBindingModel.getPassword().equals(userServiceModel.getPassword())) {
            return super.redirect("/users/login");
        }

        UserRole userRole = userServiceModel.getUserRole();

        httpSession.setAttribute("id", userServiceModel.getId());
        httpSession.setAttribute("username", userServiceModel.getUsername());
        httpSession.setAttribute("email", userServiceModel.getEmail());
        httpSession.setAttribute("role", userRole);

        if (userRole == UserRole.ADMIN) {
            return super.redirect("/admin/home");
        }

        return super.redirect("/home");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        System.out.println("TRUE");
        session.invalidate();
        return this.redirect("/");
    }
}