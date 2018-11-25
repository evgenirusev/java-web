package com.rusev.springauth.services;

import com.rusev.springauth.models.binding.UserRegisterBindingModel;

public interface UserService {
    void saveUser(UserRegisterBindingModel userRegisterBindingModel);
}
