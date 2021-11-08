package com.ds.watchtable.controller;

import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.service.PosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
public class PosController {
    @Autowired
    private final PosService posService;

    @PostMapping("/pos/postable")
    public void registerPost(PosDTO posDTO){
        log.info("Register............");
        posService.posSetting(posDTO);
    }

    @RequestMapping({"/pos/posorder","/pos/postable"})
    public void read(int posNum, Model model){
        PosDTO pos = posService.read(posNum);
        model.addAttribute("pos", pos);
    }

}