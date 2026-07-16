package com.userfront.service;

import java.math.BigDecimal;
import java.security.Principal;

import com.userfront.domain.User;

public interface BankingSqlService {

    void depositPrimaryViaProcedure(Principal principal, double amount);

    void withdrawPrimaryViaProcedure(Principal principal, double amount);

    void transferPrimaryToSavingsViaProcedure(Principal principal, double amount);

    BigDecimal getPrimaryBalanceViaProcedure(Principal principal);
}
