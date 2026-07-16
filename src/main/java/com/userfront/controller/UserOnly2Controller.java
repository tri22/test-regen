package com.userfront.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userfront.domain.User;
import com.userfront.service.UserService;

@Controller
@RequestMapping("/user-only-2")
public class UserOnly2Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findUserList();
    }
}
