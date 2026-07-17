package com.userfront.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/banking-only")
public class BankingOnlyController {


    @RequestMapping(value = "/check-balance", method = RequestMethod.GET)
    public String checkBalance() {
        return "check-balance";
    }
}
