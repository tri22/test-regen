package com.userfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.dao.Balance;
import com.userfront.service.BankingService;

@Controller
@RequestMapping("/banking-only")
public class BankingOnlyController {

    @Autowired
    private BankingService bankingService;

    @RequestMapping(value = "/check-balance", method = RequestMethod.GET)
    public String checkBalance(Model model) {
        bankingService.checkBalance(new Balance(1000));
        return "check-balance";
    }
}
