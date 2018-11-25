package com.rusev.springauth.services;

import com.rusev.springauth.entities.User;
import com.rusev.springauth.models.binding.UserRegisterBindingModel;
import com.rusev.springauth.models.service.UserServiceModel;
import com.rusev.springauth.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveUser(UserRegisterBindingModel userRegisterBindingModel) {
        User user = this.modelMapper.map(userRegisterBindingModel, User.class);
        this.userRepository.save(user);
    }

    @Override
    public UserServiceModel getUserByUsername(String username) {
        User user = this.userRepository.findByUsername(username);
        UserServiceModel userServiceModel = this.modelMapper.map(user, UserServiceModel.class);
        return userServiceModel;
    }
}
