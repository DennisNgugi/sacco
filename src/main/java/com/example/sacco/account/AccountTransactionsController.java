package com.example.sacco.account;

import com.example.sacco.exceptions.AccountNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class AccountTransactionsController {

    @Autowired
    private AccountTransactionsService accountTransactionsService;
    private final Logger LOGGER = LoggerFactory.getLogger(AccountTransactions.class);

    @PostMapping("{id}")
    public ResponseEntity<AccountTransactions> saveTransaction(@PathVariable("id") Long accountId,@RequestBody AccountTransactions accountTransactions) throws AccountNotFoundException {

       LOGGER.info("Inside save transactions of Account Transaction Controller");
       AccountTransactions accountTransactions1 = accountTransactionsService.saveTransaction(accountId, accountTransactions);
       return new ResponseEntity<AccountTransactions>(accountTransactions1, HttpStatus.CREATED);
    }



}
