package com.ds.watchtable.controller;

import com.ds.watchtable.dto.*;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.service.ReviewService;
import com.ds.watchtable.service.StoreService;
import com.ds.watchtable.service.WaitingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping
public class WaitingController {

    @Autowired
    final private WaitingService waitingService;

    //웨이팅 등록
    @RequestMapping("/addWaiting/{storeNum}")
    public ResponseEntity<Long> addWaiting(@RequestBody WaitingDTO waitingDTO) {
        Long waitingNum = waitingService.registerWaiting(waitingDTO);
        return new ResponseEntity<>(waitingNum, HttpStatus.OK);
    }

    //웨이팅 수정
    @PutMapping("/modifyWaiting/{waitingNum}")
    public ResponseEntity<Long> modifyWaiting(@PathVariable Long waitingNum,
                                             @RequestBody WaitingDTO waitingDTO){
        waitingService.modify(waitingDTO);
        return new ResponseEntity<>( waitingNum, HttpStatus.OK);
    }

    //웨이팅 취소
    @DeleteMapping("/modifyWaiting/{waitingNum}")
    public ResponseEntity<Long> cancelWaiting( @PathVariable Long waitingNum){
        waitingService.remove(waitingNum);
        log.info("removewaitingcontroller======"+waitingNum);
        return new ResponseEntity<>( waitingNum, HttpStatus.OK);
    }


}
