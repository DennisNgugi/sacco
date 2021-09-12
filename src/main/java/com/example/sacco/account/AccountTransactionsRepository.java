package com.example.sacco.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions, Long> {

}
