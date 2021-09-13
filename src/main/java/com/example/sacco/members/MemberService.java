package com.example.sacco.members;

import com.example.sacco.account.Account;
import com.example.sacco.account.AccountRepository;
import com.example.sacco.exceptions.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberService {
    
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private AccountRepository accountRepository;

    public List<Member> getMembers() {
    return memberRepository.findAll();
    }
    @Transactional
    public Member saveMember(Member member) {
        //System.out.println("member = " + member);

        NextOfKin nextOfKin = NextOfKin.builder()
                .name(member.getNextOfKin().getName())
                .phoneNumber(member.getNextOfKin().getPhoneNumber())
                .relationship(member.getNextOfKin().getRelationship())
                .build();
        Account account = Account.builder()
                .accountNumber(member.getIdNumber())
                .accountType(member.getAccount().getAccountType())
                .openAccount(member.getAccount().getOpenAccount())
                .accountBalance(member.getAccount().getAccountBalance())
                .build();
        member = Member.builder()
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .emailAddress(member.getEmailAddress())
                .idNumber(member.getIdNumber())
                .phoneNumber(member.getPhoneNumber())
                .nextOfKin(nextOfKin)
                .account(account)
                .build();



        return memberRepository.save(member);
    }

    public Member getMemberById(Long memberId) throws MemberNotFoundException {

        Optional<Member> member = memberRepository.findById(memberId);
        if(!member.isPresent()){
            throw new MemberNotFoundException("Member Not Available");
        }
        return member.get();
    }

    public void deleteMember(Long memberId) {
         memberRepository.deleteById(memberId);
    }

    public Member updateMember(Long memberId, Member member) {
        Member member1 = memberRepository.findById(memberId).get();
        return member1;
    }
}
