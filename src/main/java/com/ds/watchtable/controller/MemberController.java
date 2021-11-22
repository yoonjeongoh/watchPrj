package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.repository.MemberRepository;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private MemberRepository memberRepository;
    //db 저장
    @PostMapping("/join/login")
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
//    @PutMapping("/join/login")
//    public void update(@PathVariable Long memberNum, String newSocial) {
//        memberRepository.findById(memberNum);
//        Member member = new Member();
//        Member.builder().fromSocial(true).build();
//        log.info("member.isFromSocial()"+member.isFromSocial());
//        memberRepository.save(member);
//    }
    @PostMapping("/member/myinfo")
    public String update(MemberDTO member) {
        log.info("modify...........");
        memberService.modify(member);
        return "redirect:/";
    }

    @RequestMapping({"/memeber/myinfo", "/member/myinfocorrect", "/manager/manageinfo", "/join/socialJoin"})
    public void myinfo(Model model, MemberDTO memberDTO,
                       @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()1" + principal.getMember());
        }
    }
    @RequestMapping(value = "/member/idCheck")
    @ResponseBody
    public String idCheck(HttpServletRequest request, Model model){
        String memberId = request.getParameter("memberId");
        int rowcount = memberRepository.idCheck(memberId);
        return String.valueOf(rowcount);
    }
}





