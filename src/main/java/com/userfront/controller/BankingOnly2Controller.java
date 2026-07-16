package com.userfront.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.service.AccountService;
import com.userfront.service.BankingSqlService;

@Controller
@RequestMapping("/banking-only-2")
public class BankingOnly2Controller {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BankingSqlService bankingSqlService;

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdraw(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");
        return "withdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdrawPOST(@ModelAttribute("amount") String amount,
            @ModelAttribute("accountType") String accountType, Principal principal) {
        if (accountType.equalsIgnoreCase("Primary")) {
            bankingSqlService.withdrawPrimaryViaProcedure(principal, Double.parseDouble(amount));
        } else {
            accountService.withdraw(accountType, Double.parseDouble(amount), principal);
        }
        return "redirect:/userFront";
    }
}
