package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.security.service.ClubOAuth2UserDetailsService;
import com.ds.watchtable.security.service.MemberDetailsService;
import com.ds.watchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping
public class WatchtableController {

    private final StoreService storeService;

    @GetMapping({"/manager/manageinfocorrect","/manager/managemyinfo",
            "/review/storereview","/pos/kitchen"})

    public void list(){
    }

    // /watchtable
//    @GetMapping("")
//    public String list(PageRequestDTO pageRequestDTO, Model model){
//        log.info("pageRequestDTO: "+pageRequestDTO);
//        PageResultDTO result = storeService.getLGHlist(pageRequestDTO);
//        log.info(">>"+result);
//        model.addAttribute("result", result);
//        return "/index";
//    }
    @GetMapping("")
    public String main (Model model, MemberDTO memberDTO, @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if(principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()"+principal.getMember());
        }
        return "index";
    }
}