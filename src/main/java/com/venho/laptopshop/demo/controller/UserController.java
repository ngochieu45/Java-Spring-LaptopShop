package com.venho.laptopshop.demo.controller;

import com.venho.laptopshop.demo.domain.User;
import com.venho.laptopshop.demo.service.UploadService;
import com.venho.laptopshop.demo.service.UserService;

import jakarta.servlet.ServletContext;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    private final UserService userService;
    private final ServletContext servletContext;
    private final UploadService uploadService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, ServletContext servletContext, UploadService uploadService,
            PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.servletContext = servletContext;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUser = this.userService.getAllUserByEmail("quynhnhu0405@gmail.com");
        System.out.println(arrUser);
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserInfo(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users1", users);
        model.addAttribute("newUser", new User());
        return "/admin/user/show";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "/admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String createUserPage(Model model, @ModelAttribute("newUser") User hieu,
            @RequestParam("avatarFile") MultipartFile file) {

        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(hieu.getPassword());

        hieu.setAvatar(avatar);
        hieu.setPassword(hashPassword);
        hieu.setRole(this.userService.getRoleByName(hieu.getRole().getName()));
        this.userService.handleSaveUser(hieu);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/{id}")
    public String getUserDetail(Model model, @PathVariable("id") long id) {
        model.addAttribute("id", id);
        User userDetail = userService.getUserDetail(id);
        model.addAttribute("user", userDetail);
        return "/admin/user/detail";
    }

    @GetMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable("id") long id) {
        model.addAttribute("id", id);
        User userDetail = userService.getUserDetail(id);
        model.addAttribute("user", userDetail);
        return "/admin/user/update";
    }

    @PostMapping("/admin/user/update/{id}")
    public String updateUserById(@ModelAttribute("User") User updateUser) {
        User currentUser = this.userService.getUserById(updateUser.getId());
        if (currentUser != null) {
            currentUser.setFullName(updateUser.getFullName());
            currentUser.setAddress(updateUser.getAddress());
            currentUser.setPhone(updateUser.getPhone());
            currentUser.setRole(this.userService.getRoleByName(updateUser.getRole().getName()));
            userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable("id") long id) {
        model.addAttribute("id", id);
        return "/admin/user/delete";
    }

    @PostMapping("/admin/user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.deleteUserById(id);
        return "redirect:/admin/user";
    }

}
