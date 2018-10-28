package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.models.binding.CreateUserBindingModel;
import com.example.demo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean saveUser(CreateUserBindingModel createUserBindingMode) {
        User user = this.modelMapper.map(createUserBindingMode, User.class);
        return this.userRepository.save(user) != null;
    }
}
