package com.ds.watchtable.controller;

import com.ds.watchtable.dto.*;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.service.StoreService;
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

    @GetMapping("/store/detail")
    public void read(Long storeNum, @ModelAttribute("pageRequestDTO")
            PageRequestDTO pageRequestDTO, Model model) {
        StoreDTO storeDTO = storeService.getStore(storeNum);
        model.addAttribute("dto", storeDTO);
    }

//    @RequestMapping("/manager/managemyinfo")
//    public void getiing(Long storeNum, Model model, Store store) {
//        Optional<Store> result = Optional.ofNullable(storeService.getInfo(storeNum));
//        log.info(">>33" + storeNum);
//        if (result.isPresent()) {
//            model.addAttribute("store", result.get());
//            log.info(">>44" + result.get());
//        }
//    }

    @RequestMapping("/manager/managemyinfo")
    public void myinfo1(Model model,
                        @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if (principal != null) {
            model.addAttribute("store", principal.getStore());
            log.info("principal.getStore()" + principal.getStore());
        }

    }
}