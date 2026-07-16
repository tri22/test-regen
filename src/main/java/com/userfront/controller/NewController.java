package com.userfront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.userfront.domain.User;
import com.userfront.service.UserService;
import com.userfront.dao.NewDao;

public class NewController {
    @Autowired
    private UserService userService;

    private NewDao newDao;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findUserList();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}