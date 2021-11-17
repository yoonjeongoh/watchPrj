package com.ds.watchtable.controller;

import com.ds.watchtable.dto.SettingDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.service.SettingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping()
public class SettingController {

    private final SettingService settingService;

    //DB저장
    @GetMapping("/pos/setting")
    public void setting(SettingDTO settingDTO){
        log.info("Register............");
        settingService.storeSetting(settingDTO);
    }

}
