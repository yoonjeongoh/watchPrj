package com.ds.watchtable.controller;

import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/managerjoin")
@Log4j2
@RequiredArgsConstructor
public class StoreController {
    @Autowired
    private final StoreService storeService;

    @PostMapping({"/watchtable/detailed"})
    public void registerPost(StoreDTO storeDTO){
        log.info("Register............");
        storeService.storeRegister(storeDTO);
    }
}
