package com.venho.laptopshop.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.venho.laptopshop.demo.domain.Role;
import com.venho.laptopshop.demo.domain.User;
import com.venho.laptopshop.demo.domain.dto.RegisterDTO;
import com.venho.laptopshop.demo.repository.RoleRepository;
import com.venho.laptopshop.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public List<User> getAllUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

    public User getUserDetail(long id) {
        return this.userRepository.findById(id);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

    public User registerDTOtoUser(RegisterDTO registerDTO) {
        User user = new User();

        user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());

        return user;
    }

    public boolean checkEmailExist(String email) {
        return this.userRepository.existsByEmail(email);
    }
}
