package com.ds.watchtable.controller;

import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.entity.Pos;
import com.ds.watchtable.repository.PosRepository;
import com.ds.watchtable.service.PosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
@RequiredArgsConstructor
public class PosController {
    @Autowired
    private final PosService posService;

    @Autowired
    private PosRepository posRepository;

    @RequestMapping("/pos/postable")
    public void registerPost(PosDTO posDTO) {
        log.info("Register............");
        posService.posSetting(posDTO);
    }

//    @GetMapping({"/pos/posorder"})
//    public void read(long posNum,Model model) {
//        log.info("posNum:"+posNum);
//        Pos posDTO1 = posRepository.getById(posNum);
//        model.addAttribute("pos", posDTO1);
//    }

    @GetMapping({"/pos/posorder"})
    public void posorder(Model model) {
        List<PosDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(i -> {
            PosDTO dto = PosDTO.builder()
                    .posNum(i)
                    .menu1("first " + i)
                    .build();
            return dto;
        }).collect(Collectors.toList());
        model.addAttribute("pos", list);
    }
}