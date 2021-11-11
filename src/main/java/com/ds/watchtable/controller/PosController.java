package com.ds.watchtable.controller;

import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.entity.Pos;
import com.ds.watchtable.repository.PosRepository;
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
    private PosRepository posRepository;

    @PostMapping("/pos/postable")
    public void registerPost(PosDTO posDTO){
        log.info("Register............");
        posService.posSetting(posDTO);
    }

//    @RequestMapping({"/pos/posorder","/pos/postable"})
//    public void list(long posNum, Model model) {
//        Optional<Pos> posList = posRepository.findById(posNum);
//        model.addAttribute("pos", posList);
//    }
    @GetMapping("/pos/posorder")
    public ResponseEntity<List<PosDTO>> getPosList(@PathVariable("posNum") Long posNum){
        List<PosDTO> posDTOList = posService.getPosList(posNum);
        return new ResponseEntity<>(posDTOList, HttpStatus.OK);
    }

}