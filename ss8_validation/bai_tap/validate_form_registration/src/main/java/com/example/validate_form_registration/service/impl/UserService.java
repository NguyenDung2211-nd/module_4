package com.example.validate_form_registration.service.impl;

import com.example.validate_form_registration.entity.User;
import com.example.validate_form_registration.repository.UserRepository;
import com.example.validate_form_registration.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
