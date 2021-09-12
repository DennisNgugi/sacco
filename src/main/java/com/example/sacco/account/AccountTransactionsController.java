package com.example.sacco.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class AccountTransactionsController {

    @Autowired
    private AccountTransactionsService accountTransactionsService;
    private final Logger LOGGER = LoggerFactory.getLogger(AccountTransactions.class);

    @PostMapping
    public ResponseEntity<AccountTransactions> saveTransaction(@RequestBody AccountTransactions accountTransactions){
       LOGGER.info("Inside save transactions of Account Transaction Controller");
       AccountTransactions accountTransactions1 = accountTransactions.saveTransaction(accountTransactions);
       return new ResponseEntity<AccountTransactions>(accountTransactions1, HttpStatus.CREATED);
    }



}
