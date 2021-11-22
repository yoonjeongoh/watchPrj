package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.security.service.ClubOAuth2UserDetailsService;
import com.ds.watchtable.security.service.MemberDetailsService;
import com.ds.watchtable.service.MemberService;
import com.ds.watchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
public class WatchtableController {

    private final StoreService storeService;
    private final MemberService memberService;

    @GetMapping({"/manager/manageinfocorrect", "/review/storereview",
            "/pos/kitchen"})

    public void list(){
    }


    @RequestMapping("")
    public String main (Model model, MemberDTO memberDTO, PageRequestDTO pageRequestDTO,
                        @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if(principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("r"+principal.getMember());
        }
        log.info("pageRequestDTO: "+pageRequestDTO);
        PageResultDTO result = storeService.getStoreList(pageRequestDTO);
        log.info(">>"+result);
        model.addAttribute("result", result);
        return "index";
    }

//         /watchtable
/*    @GetMapping("")
    public String list(PageRequestDTO pageRequestDTO, Model model){
        log.info("pageRequestDTO: "+pageRequestDTO);
        PageResultDTO result = storeService.getLGHlist(pageRequestDTO);
        log.info(">>"+result);
        model.addAttribute("result", result);
        return "/index";
    }*/

 /*   @GetMapping("/store/datail")
    public void read(Long storeNum, @ModelAttribute("pageRequestDTO")
            PageRequestDTO pageRequestDTO , Model model) {
        StoreDTO storeDTO = storeService.getStore(storeNum);
        model.addAttribute("dto", storeDTO);
    }*/

}