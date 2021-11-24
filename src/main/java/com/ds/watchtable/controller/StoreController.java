package com.ds.watchtable.controller;

import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.dto.PosTableDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.dto.*;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.MemberRole;
import com.ds.watchtable.entity.PosTable;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.service.StoreService;
import com.ds.watchtable.service.WaitingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping
public class StoreController {
    @Autowired
    private final StoreService storeService;
    @Autowired
    private final WaitingService waitingService;

    //store/detail - member, store 정보 넘기기
    @GetMapping("/store/detail")
    public void read(Long storeNum, @ModelAttribute("pageRequestDTO")
            PageRequestDTO pageRequestDTO, Model model, Long reviewNum,
                     @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()" + principal.getMember());
        }
        StoreDTO storeDTO = storeService.getStore(storeNum);
        model.addAttribute("dto", storeDTO);
    }

    //스토어 principal 정보 넘기기
    @RequestMapping({"/manager/managemyinfo", "/pos/postable"})
    public void read1(Model model, @AuthenticationPrincipal ClubAuthMemberDTO principal,
                      PageRequestDTO pageRequestDTO) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
        }
        Store store = storeService.getStoreMember(principal.getMember());
        log.info("store.getMember()" + store);
        model.addAttribute("dto", store);

//        웨이팅리스트
        PageResultDTO waitingDTO = waitingService.getWaitingList(pageRequestDTO, store);
        log.info("waitinglist>>11111" + waitingDTO);
        model.addAttribute("waitingDTO", waitingDTO);

        Store storeDTO = storeService.getStoreMember(principal.getMember());
        model.addAttribute("dto", storeDTO);
        log.info("yjyj1" + storeDTO);

        PosTable posTable1 = storeService.getPosTable(storeDTO);
        log.info("yjyj12" + posTable1);
        model.addAttribute("order", posTable1);
    }


    @RequestMapping("/manager/manageinfocorrect")
    public void read2(Model model, @AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()" + principal.getMember());
        }
        model.addAttribute("store", storeService.getStoreMember(principal.getMember()));
        Store storeDTO = storeService.getStoreMember(principal.getMember());
        log.info("storeDTO.getMember22222()" + storeDTO);
    }

    @RequestMapping("/pos/postable2")
    public String update(Model model, @AuthenticationPrincipal ClubAuthMemberDTO principal,
                       PosTableDTO posTableDTO) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
        }
        Store storeDTO = storeService.getStoreMember(principal.getMember());
        model.addAttribute("dto", storeDTO);

        log.info("yjyj13" + storeDTO);

        PosTable posTable1 = storeService.getPosTable(storeDTO);
        model.addAttribute("order", posTable1);

        log.info("yjyj14" + posTable1);
        posTableDTO.setPosTableNum(posTable1.getPosTableNum());
        posTableDTO.setStoreNum(storeDTO.getStoreNum());

        log.info("yjyj15" + posTableDTO);
        storeService.modify(posTableDTO, storeDTO);
        return "redirect:/pos/postable";
    }
}