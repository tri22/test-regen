package com.userfront.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.userfront.domain.PrimaryAccount;

public interface BankingProcedureRepository extends JpaRepository<PrimaryAccount, Long> {

    @Procedure(value = "PRC_DEPOSIT_PRIMARY")
    void depositPrimary(
            @Param("p_account_id") Long accountId,
            @Param("p_amount") BigDecimal amount
    );

    @Procedure(value = "PRC_WITHDRAW_PRIMARY")
    void withdrawPrimary(
            @Param("p_account_id") Long accountId,
            @Param("p_amount") BigDecimal amount
    );

    @Procedure(value = "PRC_TRANSFER_BETWEEN_ACCOUNTS")
    void transferBetweenAccounts(
            @Param("p_from_account_id") Long fromAccountId,
            @Param("p_to_account_id") Long toAccountId,
            @Param("p_amount") BigDecimal amount
    );

    @Procedure(value = "PRC_GET_PRIMARY_BALANCE")
    BigDecimal getPrimaryBalance(@Param("p_account_id") Long accountId);
}
