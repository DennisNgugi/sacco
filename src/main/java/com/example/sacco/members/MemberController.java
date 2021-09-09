package com.example.sacco.members;

import com.example.sacco.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @GetMapping
    public List<Member> getMembers(){
        return memberService.getMembers();
    }
    @PostMapping
    public Member saveMember(@RequestBody Member member){


        return memberService.saveMember(member);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable("id") Long memberId){
        return memberService.getMemberById(memberId);
    }
    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable("id") Long memberId){
        memberService.deleteMember(memberId);
        return"Member deleted succesfully";
    }
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable("id") Long memberId, @RequestBody Member member){
       return memberService.updateMember(memberId,member);

    }
}
