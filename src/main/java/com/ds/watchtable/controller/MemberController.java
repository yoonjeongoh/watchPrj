package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //db 저장
    @RequestMapping("/join/login")
    public void registerAndMyInfo(MemberDTO memberDTO) {
        log.info("register...........");
        memberService.register(memberDTO);
//    attributes.addAttribute("username",userDTO.getUsername());
//    attributes.addAttribute("userid",userDTO.getUserid());
    }

    //    @PutMapping("/{memberNum}")
//    public ResponseEntity<Long> modifySocial(@PathVariable("memberNum") Long memberNum,
//                                       @RequestBody MemberDTO memberDTO){
//        log.info("modify.......");
//        memberService.modify(memberDTO);
//        return new ResponseEntity<>(memberNum, HttpStatus.OK);
//    }
    @PutMapping("/{memberNum}")
    public ResponseEntity<Long> modifySocial(@PathVariable("memberNum") Long memberNum,
                                             @RequestBody MemberDTO memberDTO) {
        log.info("modify.......");
        memberService.modify(memberDTO);
        return new ResponseEntity<>(memberNum, HttpStatus.OK);
    }

    @RequestMapping({"/memeber/myinfo", "/member/myinfocorrect", "/manager/manageinfo", "/join/socialJoin"})
    public void myinfo(Model model, MemberDTO memberDTO,
                       @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()" + principal.getMember());
        }
    }
}





