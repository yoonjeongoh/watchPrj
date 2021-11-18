package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MenuItemDTO;
import com.ds.watchtable.dto.SettingDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Setting;
import com.ds.watchtable.service.MenuItemService;
import com.ds.watchtable.service.SettingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping
public class PosController {
    private final SettingService settingService;
    private final MenuItemService menuItemService;

    @GetMapping("/pos/setting")
    public void list(){
    }


    @GetMapping("/pos/storeorder")
    public void storeorder(SettingDTO settingDTO){

    }

    @GetMapping("/pos/menuitem")
    public void menuitem(SettingDTO settingDTO){

    }

    @RequestMapping("/pos/storetable")
    private void registering(SettingDTO settingDTO, MenuItemDTO menuItemDTO
                                    ,Long posNum, Model model) {
        //데이터넣기
        settingService.register(settingDTO);
        log.info(">>>1111111"+settingDTO);
        menuItemService.MenuItem(menuItemDTO);


    }

    @GetMapping("/pos/storetable")
    public void storetable(Long posNum,Model model){
        SettingDTO settingDTO = settingService.getSetting(posNum);
        model.addAttribute("setting", settingDTO);
    }








}