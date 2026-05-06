package com.shashank.teamtaskmanagement.controller;

import com.shashank.teamtaskmanagement.entity.User;
import com.shashank.teamtaskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")

    public User signup(@RequestBody User user)
    {
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user)
    {
        return userService.login(user.getEmail(), user.getPassword());
    }

}
