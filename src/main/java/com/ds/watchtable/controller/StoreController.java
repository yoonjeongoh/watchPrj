package com.ds.watchtable.controller;

import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.dto.ReviewDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private final StoreService storeService;

    @GetMapping("/detail")
    public void detail(@ModelAttribute("requestDTO") PageRequestDTO
                       pageRequestDTO, Long storeNum, Model model) {
        log.info("StoreNum: " +storeNum);
        StoreDTO storeDTO = storeService.getStore(storeNum);
        log.info(storeDTO);
        model.addAttribute("dto-------------------------------------", storeDTO);
    }
}