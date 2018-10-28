package com.example.demo.services;

import com.example.demo.models.binding.CreateUserBindingModel;

public interface UserService {
    public boolean saveUser(CreateUserBindingModel createUserBindingMode);
}
