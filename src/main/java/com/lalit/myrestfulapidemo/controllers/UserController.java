package com.lalit.myrestfulapidemo.controllers;

import com.lalit.myrestfulapidemo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String getUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }
}
