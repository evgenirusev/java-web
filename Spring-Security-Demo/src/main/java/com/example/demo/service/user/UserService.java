package com.example.demo.service.user;

import com.example.demo.model.entity.User;
import com.example.demo.model.view.UserRegisterRequestModel;

public interface UserService {

    User register(UserRegisterRequestModel model);
}
