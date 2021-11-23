package com.ds.watchtable.controller;

import com.ds.watchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping
public class PosController {
    private final StoreService storeService;



//    @GetMapping({"/pos/postable"})
//    public void posTable(Model model,@AuthenticationPrincipal ClubAuthMemberDTO principal){
//        if(principal != null) {
//            model.addAttribute("order", principal.getPosTable());
//            log.info("principal.getMember()"+principal.getPosTable());
//        }
//        PosTable posTable = storeService.getPosTable(principal.getPosTable());
//        log.info("storeDTO.getMember()7777"+posTable);
//        model.addAttribute("order", posTable);
//        log.info("storeDTO.getMember()8888"+posTable);
//    }
}