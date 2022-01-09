package com.ds.watchtable.controller;

import com.ds.watchtable.dto.LikesDTO;
import com.ds.watchtable.service.LikesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping
public class LikesController {
    @Autowired
    final private LikesService likesService;

    //좋아요 추가
    @RequestMapping("/addLikes/{storeNum}")
    public ResponseEntity<Long> addLikes(@RequestBody LikesDTO likesDTO) {
        Long likesNum = likesService.registerLikes(likesDTO);
        return new ResponseEntity<>(likesNum, HttpStatus.OK);
    }


}
