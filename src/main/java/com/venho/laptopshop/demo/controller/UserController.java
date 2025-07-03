package com.venho.laptopshop.demo.controller;

import com.venho.laptopshop.demo.domain.User;
import com.venho.laptopshop.demo.repository.UserRepository;
import com.venho.laptopshop.demo.service.UserService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUser = this.userService.getAllUserByEmail("quynhnhu0405@gmail.com");
        System.out.println(arrUser);
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserInfo(Model model) {
        model.addAttribute("newUser", new User());
        return "/admin/user/showUser";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User hieu) {
        System.out.println("run" + hieu);
        this.userService.handleSaveUser(hieu);
        return "/admin/user/create";
    }
}
