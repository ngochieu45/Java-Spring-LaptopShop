package com.venho.laptopshop.demo.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/home")
    public String getMethodName() {
        return "client/homepage/show";
    }

}
