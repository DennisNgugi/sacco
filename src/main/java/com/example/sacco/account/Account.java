package com.example.sacco.account;

import com.example.sacco.members.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private Boolean openAccount;
    private Integer accountBalance;
    @OneToOne
    @JoinColumn(
            name = "member_id",
            referencedColumnName = "memberId"
    )
    private Member member;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "account_id",
            referencedColumnName = "accountId"
    )
    private List<AccountTransactions> transactions;

}