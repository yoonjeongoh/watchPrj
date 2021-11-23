
package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MenuItemDTO;
import com.ds.watchtable.dto.SettingDTO;
import com.ds.watchtable.entity.PosTable;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.service.MenuItemService;
import com.ds.watchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping
public class PosController {
    private final MenuItemService menuItemService;
    private final StoreService storeService;

    @GetMapping("/pos/setting")
    public void getlist(Long posNum,Model model){

    }
    @PostMapping("/pos/setting")
    public void setting(Long tableNum, Model model){

    }


    @GetMapping("/pos/storeorder")
    public void storeorder(SettingDTO settingDTO){

    }

    @GetMapping("/pos/menuitem")
    public void menuitem(SettingDTO settingDTO){

    }

    @RequestMapping("/pos/postable")
    private void registering(SettingDTO settingDTO, MenuItemDTO menuItemDTO
                                    ,Long posNum, Model model) {



    }

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
