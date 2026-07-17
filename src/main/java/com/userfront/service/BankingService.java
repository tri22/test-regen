package com.userfront.service;

import com.userfront.dao.Balance;

public class BankingService {

    public void checkBalance(Balance balance) {
        System.out.println("Balance: " + balance.getAmount());
    }
}
