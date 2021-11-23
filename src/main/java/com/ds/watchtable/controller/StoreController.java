package com.ds.watchtable.controller;

import com.ds.watchtable.dto.*;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.service.ReviewService;
import com.ds.watchtable.service.StoreService;
import com.ds.watchtable.service.WaitingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping()
public class StoreController {
    @Autowired
    private final StoreService storeService;
    private final WaitingService waitingService;
    private final ReviewService reviewService;

    //store/detail - member, store 정보 넘기기
    @GetMapping({"/store/detail","/manager/managemyinfo"})
    public void read(Long storeNum, Model model,@AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if(principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()"+principal.getMember());
        }
        Store storeDTO = storeService.getStoreMember(principal.getMember());
        log.info("storeDTO.getMember()"+storeDTO);
        model.addAttribute("dto", storeDTO);
        log.info("storeDTO.getMember()"+storeDTO);
    }

        //시큐리티로 데이터넘기기
    @RequestMapping("/manager/managemyinfo")
    public void myinfo1(Model model,
                        @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if (principal != null) {
            model.addAttribute("store", principal.getStore());
            log.info("principal.getStore()" + principal.getStore());
        }
    }

}