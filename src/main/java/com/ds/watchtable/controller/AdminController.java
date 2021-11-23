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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private final StoreService storeService;

    //admin/storelist
    @GetMapping({"/storelist", "/admin"})
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("pageRequestDTO: "+pageRequestDTO);
        PageResultDTO result = storeService.getStoreList(pageRequestDTO);
        log.info(">>"+result);
        model.addAttribute("result", result);
    }

    //admin/storeread
    @GetMapping("/storeread")
    public void read(Long storeNum, @ModelAttribute("pageRequestDTO")
        PageRequestDTO pageRequestDTO , Model model) {
        StoreDTO storeDTO = storeService.getStore(storeNum);
        model.addAttribute("dto", storeDTO);
    }

}
