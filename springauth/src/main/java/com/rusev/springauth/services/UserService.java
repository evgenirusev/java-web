package com.rusev.springauth.services;

import com.rusev.springauth.models.binding.UserRegisterBindingModel;
import com.rusev.springauth.models.service.UserServiceModel;

public interface UserService {
    void saveUser(UserRegisterBindingModel userRegisterBindingModel);

    UserServiceModel getUserByUsername(String username);
}
