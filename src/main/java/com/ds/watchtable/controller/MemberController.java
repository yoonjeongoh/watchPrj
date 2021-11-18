package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    //db 저장
    @PostMapping("/myinfo")
    public void registerAndMyInfo(MemberDTO memberDTO) {
        log.info("register...........");
        memberService.register(memberDTO);
    }

    @RequestMapping({"/myinfo","/myinfocorrect","/manageinfo"})
    public void myinfo (Model model, MemberDTO memberDTO,
                        @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if(principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()"+principal.getMember());
        }
    }






/*
    //내 정보 불러오기
    @RequestMapping("/myinfocorrect")
    private void getMyInfo(Long memberNum, Model model,
                           @AuthenticationPrincipal Principal principal) {


            Optional<Member> result = Optional.ofNullable(memberService.getInfo(memberNum));
            if (result.isPresent()) {
                model.addAttribute("member", result.get());
            }
            if (result == null) {
                return;
            }
        log.info("result>>"+result);
        }
*/



    }





