package com.userfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.domain.User;

@Controller
@RequestMapping("/user-only")
public class UserOnlyController {

    @Autowired
    private User user;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User getUser() {
        return user;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public User updateUser(User user) {
        return user;
    }

}
