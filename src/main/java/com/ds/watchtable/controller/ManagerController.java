package com.ds.watchtable.controller;

import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private final StoreService storeService;

    //DB저장
    @PostMapping("/managemyinfo")
    public void registerPost(StoreDTO storeDTO){
        log.info("Register............");
        storeService.storeRegister(storeDTO);
    }

    //매장 정보 불러오기..
/*    @GetMapping("/managemyinfo")
    public void managerinfo(StoreDTO storeDTO,Long storeNum, Model model,
                            @AuthenticationPrincipal Principal principal){
        log.info("Register............");
        storeService.storeRegister(storeDTO);

        log.info("storeNum>>"+storeNum);
        Optional<Store> result = Optional.ofNullable(storeService.getInfo(storeNum));
        if (result != null) {
            model.addAttribute("store", result.get());
        }
        if (result == null) {
            return;
        }
        log.info("result>>"+result);
    }*/

}
