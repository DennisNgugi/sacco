package com.example.sacco.members;

import com.example.sacco.account.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;
    private final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @GetMapping
    public List<Member> getMembers(){
        LOGGER.info("Inside list members of Member Controller");
        return memberService.getMembers();
    }
    @PostMapping
    public ResponseEntity<Member> saveMember(@Valid @RequestBody Member member){

        LOGGER.info("Inside save members of Member Controller");
        Member saveMember = memberService.saveMember(member);
        return new ResponseEntity<Member>(saveMember, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable("id") Long memberId){
        LOGGER.info("Inside get member ID of Member Controller");
        return memberService.getMemberById(memberId);
    }
    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable("id") Long memberId){
        LOGGER.info("Inside delete method of Member Controller");
        memberService.deleteMember(memberId);
        return"Member deleted succesfully";
    }
    @PutMapping("/{id}")
    public Member updateMember(@PathVariable("id") Long memberId, @RequestBody Member member){
        LOGGER.info("Inside update method of Member Controller");
        return memberService.updateMember(memberId,member);

    }
}
