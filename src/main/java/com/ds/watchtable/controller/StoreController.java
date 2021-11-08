package com.ds.watchtable.controller;

import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequestMapping
@RequiredArgsConstructor
public class StoreController {
    @Autowired
    private final StoreService storeService;

    @PostMapping("/member/managemyinfo")
    public void registerPost(StoreDTO storeDTO){
        log.info("Register............");
        storeService.storeRegister(storeDTO);
    }
}