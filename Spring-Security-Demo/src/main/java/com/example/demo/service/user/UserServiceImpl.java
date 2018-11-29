package com.example.demo.service.user;

import com.example.demo.model.entity.User;
import com.example.demo.model.view.UserRegisterRequestModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User register(UserRegisterRequestModel model) {
        User user = new User();
        user.setUsername(model.getUsername());
        user.setPassword(
                this.passwordEncoder.encode(model.getPassword())
        );

        return this.userRepository.save(user);
    }
}
