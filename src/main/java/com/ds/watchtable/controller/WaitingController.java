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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping
public class WaitingController {

    @Autowired
    final private WaitingService waitingService;
    private final StoreService storeService;

    //웨이팅 등록
    @RequestMapping("/addWaiting/{storeNum}")
    public ResponseEntity<Long> addWaiting(@RequestBody WaitingDTO waitingDTO) {
        Long waitingNum = waitingService.registerWaiting(waitingDTO);
        return new ResponseEntity<>(waitingNum, HttpStatus.OK);
    }

}
