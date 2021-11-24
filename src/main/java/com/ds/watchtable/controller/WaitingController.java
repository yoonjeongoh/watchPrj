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
        log.info("--------------addWaiting1111---------------");
        log.info("waitingDTO1111: " + waitingDTO);
        Long waitingNum = waitingService.registerWaiting(waitingDTO);
        log.info("waitingDTO2222: " + waitingDTO);
        log.info("--------------addWaiting222---------------"+waitingNum);
        return new ResponseEntity<>(waitingNum, HttpStatus.OK);
    }

    //페이징, 리스트
/*
    @GetMapping("/manager/managemyinfo")
    public void waitingList(Model model, Long waitingNum,@ModelAttribute("pageRequestDTO")
                            PageRequestDTO pageRequestDTO) {
        //페이징 + 리스트
        log.info("WatingpageRequestDTO: "+pageRequestDTO);
        PageResultDTO waitingDTO = waitingService.getWaitingList(pageRequestDTO);
        log.info("waitinglist>>11111"+waitingDTO);
        model.addAttribute("waitingDTO", waitingDTO);

*/
/*
        //정보부르기
        WaitingDTO waiting = waitingService.getWaiting(waitingNum);
        log.info("waitinglist>>22222"+waiting);
        model.addAttribute("waiting", waiting);
*//*

    }
*/

/*
    @GetMapping("/review/storereview")
    public void read(Long waitingNum, @ModelAttribute("pageRequestDTO")
        PageRequestDTO pageRequestDTO , Model model,
                     @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if(principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()"+principal.getMember());
        }
        Store storeDTO = storeService.getStoreMember(principal.getMember());
        log.info("storeDTO.getMember()"+storeDTO);

        model.addAttribute("dto", storeDTO);
        log.info("storeDTO.getMember()"+storeDTO);

        WaitingDTO waitingDTO = waitingService.getWaiting(waitingNum);
        log.info("waitinglist>>22222"+waitingDTO);
        model.addAttribute("waiting", waitingDTO);
    }
*/

/*
    @RequestMapping("/manager/managemyinfo")
    public void waitingList(Model model, Long waitingNum,
                            PageRequestDTO pageRequestDTO) {
        log.info("WatingpageRequestDTO: "+pageRequestDTO);
        PageResultDTO waitingDTO = waitingService.getWaitingList(pageRequestDTO);
        log.info("waitinglist>>11111"+waitingDTO);
        model.addAttribute("waitingDTO", waitingDTO);
    }
*/


}
