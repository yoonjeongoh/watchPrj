package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MenuItemDTO;
import com.ds.watchtable.dto.SettingDTO;
import com.ds.watchtable.service.MenuItemService;
import com.ds.watchtable.service.SettingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
public class PosController {
    @Autowired
    private final SettingService settingService;
    @Autowired
    private final MenuItemService menuItemService;


    @GetMapping("/pos/storeorder")
    public void storeorder(SettingDTO settingDTO){

    }

    @GetMapping("/pos/storetable")
    public void storetable(SettingDTO settingDTO){

    }
    @PostMapping("/pos/setting")
    public void menuitem(SettingDTO settingDTO, MenuItemDTO menuItemDTO){
           }
    @GetMapping("/pos/setting")
    public void getmenuitem(SettingDTO settingDTO, MenuItemDTO menuItemDTO){

        log.info(">>>>>>>>>>>settingDTO : "+settingDTO);
        log.info(">>>>>>>>>>>menuItemDTO : "+menuItemDTO);
        settingService.storeSetting(settingDTO);
        menuItemService.MenuItem(menuItemDTO);
        log.info(">>>>>>>>>>>settingDTO2 : "+settingDTO);
        log.info(">>>>>>>>>>>menuItemDTO2 : "+menuItemDTO);
    }


//    @GetMapping("/pos/postable")
//    public void registerPos(PosDTO posDTO, PosOrderDTO posOrderDTO){
//        posService.posSetting(posDTO);
//        posOrderService.posOrder(posOrderDTO);
//        log.info("Register............");
//    }
//    @GetMapping("/pos/postable")
//    public void table(Long orderNum, Long posNum, Model model, Model model2){
//        log.info("orderNum>>"+orderNum);
//        Optional<PosOrder> result = Optional.ofNullable(posOrderService.getPosOrder(orderNum));
//        if (result != null) {
//            model.addAttribute("posOrder", result.get());
//        }
//        if (result == null) {
//            return;
//        }
//
//    }
//    @GetMapping("/pos/posorder")
//    public void Order(Long orderNum, Long posNum, Model model, Model model2){
//      log.info("orderNum>>"+posNum);
//        Optional<Pos> result = Optional.ofNullable(posService.getPos(posNum));
//        if (result != null) {
//            model.addAttribute("pos", result.get());
//        }
//        if (result == null) {
//            return;
//        }
//
//    }
//    @PostMapping("/pos/posorder")
//    public void PosOrder(PosOrderDTO posOrderDTO){
//        log.info("Register............");
//        posOrderService.posOrder(posOrderDTO);
//    }




}