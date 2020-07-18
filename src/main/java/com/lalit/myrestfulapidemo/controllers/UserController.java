package com.lalit.myrestfulapidemo.controllers;

import com.lalit.myrestfulapidemo.domain.User;
import com.lalit.myrestfulapidemo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @GetMapping({"users"})
    @ResponseBody
    public Set<User> getUsersWithRest(){
        Set<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping({"user/{id}"})
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping({"user"})
    public User addUser(User user){
        return userService.saveUser(user);
    }
}
