package com.example.sacco.members;

import com.example.sacco.account.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    @Id
    @SequenceGenerator(
            name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence"
    )
    private Long memberId;
    private Integer idNumber;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    @Embedded
    private NextOfKin nextOfKin;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Account account;


}
