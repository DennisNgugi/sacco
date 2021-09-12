package com.example.sacco.account;

import com.example.sacco.exceptions.AccountNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    private final Logger LOGGER = LoggerFactory.getLogger(Account.class);


    @GetMapping("{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long accountId) throws AccountNotFoundException {
        LOGGER.info("Inside get account ID of Account Controller");
        Account checkAccount = accountService.getAccountById(accountId);
        return new ResponseEntity<Account>(checkAccount, HttpStatus.OK);

    }
}
