package com.ds.watchtable.controller;

import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.dto.PosOrderDTO;
import com.ds.watchtable.entity.Pos;
import com.ds.watchtable.repository.PosRepository;
import com.ds.watchtable.service.PosOrderService;
import com.ds.watchtable.service.PosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
@RequiredArgsConstructor
public class PosController {
    @Autowired
    private final PosService posService;

    @Autowired
    private final PosOrderService posOrderService;

    @Autowired
    private PosRepository posRepository;

    @RequestMapping("/pos/postable")
    public void registerPos(PosDTO posDTO, PosOrderDTO posOrderDTO){
        posService.posSetting(posDTO);
        posOrderService.posOrder(posOrderDTO);
        log.info("Register............");
    }

    @RequestMapping("/pos/posorder")
    public void PosOrder(PosDTO posDTO){
        log.info("Register............");
    }

    @RequestMapping("/pos/possetting")
    public void PosSetting(PosDTO posDTO){
        log.info("Register............");
    }

//    @RequestMapping({"/pos/posorder","/pos/postable"})
//    public void list(long posNum, Model model) {
//        Opti  onal<Pos> posList = posRepository.findById(posNum);
//        model.addAttribute("pos", posList);
//    }


    //    @GetMapping("/pos/posorder")
//    public void read(Long posNum, Model model) {
//        PosDTO posDTO = posService.getPos(posNum);
//        model.addAttribute("pos", posDTO);
//    }
}