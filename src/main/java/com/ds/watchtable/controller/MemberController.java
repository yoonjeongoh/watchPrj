package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    //test중
    @RequestMapping("/myinfo/{memberNum}")
    public void registerAndMyInfo(MemberDTO memberDTO, Long memberNum, Model model,
                                  @AuthenticationPrincipal Principal principal) {
        log.info("register...........");
        memberService.register(memberDTO);

        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("memberNum>>"+memberNum);
        Optional<Member> result = Optional.ofNullable(memberService.getInfo(memberNum));
        if (result != null) {
            model.addAttribute("mem", result.get());
        }
        if (result == null) {
            return;
        }
    }

    //내 정보 불러오기
    @GetMapping("/myinfocorrect")
    private void getMyInfo(Long memberNum, Model model,
                           @AuthenticationPrincipal Principal principal) {
       SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       log.info("memberNum>>"+memberNum);
       Optional<Member> result = Optional.ofNullable(memberService.getInfo(memberNum));
//        Optional<Member> result = memberService.getInfo(memberNum);
        if (result != null) {
            model.addAttribute("mem", result.get());
        }
        if (result == null) {
            return;
        }
        log.info("result>>"+result);
    }

  //db 저장 백업
/*    @RequestMapping("/myinfo")
    public void registerAndMyInfo(MemberDTO memberDTO) {
        log.info("register...........");
        memberService.register(memberDTO);
//    attributes.addAttribute("username",userDTO.getUsername());
//    attributes.addAttribute("userid",userDTO.getUserid());
    }*/



    //그냥 틀려먹음
/*
    @GetMapping("/myinfocorrect") //get-불러오기
    private void getMyInfo(Model model, @AuthenticationPrincipal Principal principal) {
        List<MemberDTO> dto = memberService.getAll();
        model.addAttribute("memberDTO", dto);
        log.info("dto>>" + dto);
        }
*/

}


