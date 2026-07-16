package com.userfront.service.UserServiceImpl;

import java.math.BigDecimal;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userfront.dao.BankingProcedureRepository;
import com.userfront.domain.PrimaryAccount;
import com.userfront.domain.SavingsAccount;
import com.userfront.domain.User;
import com.userfront.service.BankingSqlService;
import com.userfront.service.UserService;

@Service
public class BankingSqlServiceImpl implements BankingSqlService {

    @Autowired
    private BankingProcedureRepository bankingProcedureRepository;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void depositPrimaryViaProcedure(Principal principal, double amount) {
        PrimaryAccount account = resolvePrimaryAccount(principal);
        bankingProcedureRepository.depositPrimary(account.getId(), BigDecimal.valueOf(amount));
    }

    @Override
    @Transactional
    public void withdrawPrimaryViaProcedure(Principal principal, double amount) {
        PrimaryAccount account = resolvePrimaryAccount(principal);
        bankingProcedureRepository.withdrawPrimary(account.getId(), BigDecimal.valueOf(amount));
    }

    @Override
    @Transactional
    public void transferPrimaryToSavingsViaProcedure(Principal principal, double amount) {
        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        SavingsAccount savingsAccount = user.getSavingsAccount();
        bankingProcedureRepository.transferBetweenAccounts(
                primaryAccount.getId(),
                savingsAccount.getId(),
                BigDecimal.valueOf(amount)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getPrimaryBalanceViaProcedure(Principal principal) {
        PrimaryAccount account = resolvePrimaryAccount(principal);
        return bankingProcedureRepository.getPrimaryBalance(account.getId());
    }

    private PrimaryAccount resolvePrimaryAccount(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return user.getPrimaryAccount();
    }
}
