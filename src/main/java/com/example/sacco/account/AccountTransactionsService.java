package com.example.sacco.account;

import com.example.sacco.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
public class AccountTransactionsService {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;
    @Autowired
    private AccountService accountService;

    public AccountTransactions saveTransaction(Long accountId, AccountTransactions accountTransactions) throws AccountNotFoundException {
        Account account = accountService.getAccountById(accountId);

       // LocalDateTime localDateTime = LocalDateTime.now();
        accountTransactions = AccountTransactions.builder()
                .transactionCode(accountTransactions.getTransactionCode())
                .transactionType(accountTransactions.getTransactionType())
                .transactionAmount(accountTransactions.getTransactionAmount())
                .transactionDate(accountTransactions.getTransactionDate())
                .account(account)
                .build();

        return accountTransactionsRepository.save(accountTransactions);

    }
}
