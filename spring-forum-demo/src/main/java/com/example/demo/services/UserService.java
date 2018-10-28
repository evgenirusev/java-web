package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.models.binding.CreateUserBindingModel;

import java.util.List;

public interface UserService {
    public boolean saveUser(CreateUserBindingModel createUserBindingMode);

    public List<User> getUsers();
}
