package com.ds.watchtable.controller;

import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping
public class WatchtableController {

    private final StoreService storeService;

    @GetMapping({"/manager/manageinfocorrect","/manager/managemyinfo",
            "/review/storereview","/pos/kitchen","/pos/loginmng",
            "/pos/setting","/pos/storetable","/pos/order","/pos/menuitem"})

    public void list(){
    }

    // /watchtable
/*
    @GetMapping("")
    public String getInfo(Model model, @AuthenticationPrincipal Principal principal){
        if (principal != null) {
            log.info(">>" + principal.getName());
        }
//        model.addAttribute("mem",principal.getName())
        return "/index";
    }
*/

/*    @GetMapping("")
    public String list(PageRequestDTO pageRequestDTO, Model model,@AuthenticationPrincipal Principal principal){
        log.info("pageRequestDTO: "+pageRequestDTO);
        PageResultDTO result = storeService.getLGHlist(pageRequestDTO);
        log.info(">>"+result);
        model.addAttribute("result", result);
        log.info(">>"+principal.getName());
//        model.addAttribute("mem",principal.getName())
        return "/index";
    }*/

}