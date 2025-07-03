package com.venho.laptopshop.demo.service;

import org.springframework.stereotype.Service;

import com.venho.laptopshop.demo.domain.User;
import com.venho.laptopshop.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "hand job me";
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }
}
