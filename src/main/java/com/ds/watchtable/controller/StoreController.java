package com.ds.watchtable.controller;

import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
public class StoreController {
    @Autowired
    private final StoreService storeService;

    //DB저장
    @PostMapping("/member/managemyinfo")
    public void registerPost(StoreDTO storeDTO){
        log.info("Register............");
        storeService.storeRegister(storeDTO);
    }
    //admin list
    @GetMapping("/admin/storelist")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("pageRequestDTO: "+pageRequestDTO);
        PageResultDTO result = storeService.getList(pageRequestDTO);
        log.info(">>"+result);
        model.addAttribute("result", result);
    }

    //admin read
    @GetMapping("/admin/storeread")
    public void read(Long storeNum, @ModelAttribute("pageRequestDTO") PageRequestDTO pageRequestDTO , Model model) {
        StoreDTO storeDTO = storeService.getStore(storeNum);
        model.addAttribute("dto", storeDTO);
    }

}