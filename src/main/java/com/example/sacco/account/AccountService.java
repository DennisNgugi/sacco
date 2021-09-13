package com.example.sacco.account;

import com.example.sacco.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(Long accountId) throws AccountNotFoundException {
        Optional<Account> account = accountRepository.findById(accountId);
        if(!account.isPresent()){
            throw new AccountNotFoundException("Cannot find account of ID " +accountId);
        }
        return account.get();
    }
}
