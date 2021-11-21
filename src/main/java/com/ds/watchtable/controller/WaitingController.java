package com.ds.watchtable.controller;

import com.ds.watchtable.dto.ReviewDTO;
import com.ds.watchtable.dto.WaitingDTO;
import com.ds.watchtable.service.ReviewService;
import com.ds.watchtable.service.WaitingService;
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
public class WaitingController {

    @Autowired
    final private WaitingService waitingService;

    //리뷰등록
    @RequestMapping("/addWaiting/{storeNum}")
    public ResponseEntity<Long> addWaiting(@RequestBody WaitingDTO waitingDTO) {
        log.info("--------------addWaiting1111---------------");
        log.info("waitingDTO1111: " + waitingDTO);
        Long waitingNum = waitingService.registerWaiting(waitingDTO);
        log.info("waitingDTO2222: " + waitingDTO);
        log.info("--------------addWaiting222---------------"+waitingNum);
        return new ResponseEntity<>(waitingNum, HttpStatus.OK);
    }

}
