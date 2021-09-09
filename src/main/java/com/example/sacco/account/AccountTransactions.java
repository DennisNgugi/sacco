package com.example.sacco.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private Integer transactionCode;
    private Date transactionDate;
    private String transactionAmount;


}
