package com.ds.watchtable.controller;

import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.dto.PosTableDTO;
import com.ds.watchtable.dto.StoreDTO;
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
@RequestMapping()
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
        if(principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()"+principal.getMember());
        }
        StoreDTO storeDTO = storeService.getStore(storeNum);
        model.addAttribute("dto", storeDTO);
    }

    //스토어 principal 정보 넘기기
    @RequestMapping("/manager/managemyinfo")
    public void read1(Model model, @AuthenticationPrincipal ClubAuthMemberDTO principal,
                      PageRequestDTO pageRequestDTO) {
        if(principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()"+principal.getMember());
        }
        Store store = storeService.getStoreMember(principal.getMember());
        log.info("store.getMember()"+store);
        model.addAttribute("dto", store);

//        웨이팅리스트
        PageResultDTO waitingDTO = waitingService.getWaitingList(pageRequestDTO, store);
        log.info("waitinglist>>11111"+waitingDTO);
        model.addAttribute("waitingDTO", waitingDTO);

        PosTable posTable1 = storeService.getPosTable(store);
        log.info("storeDTO.getMember()"+store);
        model.addAttribute("order", posTable1);
        log.info("posTable>>>>>>>>>>>>"+posTable1);
        log.info("posTable>>>>>>>>>>>>"+posTable1);
    }

    //스토어 principal 정보 넘기기
    @RequestMapping("/manager/manageinfocorrect")
    public void read2(Model model,@AuthenticationPrincipal ClubAuthMemberDTO principal) {
        if (principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()" + principal.getMember());
        }
        model.addAttribute("store", storeService.getStoreMember(principal.getMember()));
        Store storeDTO = storeService.getStoreMember(principal.getMember());
        log.info("storeDTO.getMember22222()" + storeDTO);
    }

        @PostMapping("/pos/postable")
    public void update(Model model,@AuthenticationPrincipal ClubAuthMemberDTO principal,
                       PosTableDTO posTableDTO) {
        if(principal != null) {
            model.addAttribute("member", principal.getMember());
            log.info("principal.getMember()11"+principal.getMember());
        }
        Store storeDTO = storeService.getStoreMember(principal.getMember());
        log.info("storeDTO.getMember()11"+storeDTO);
        model.addAttribute("dto", storeDTO);

        PosTable posTable1 = storeService.getPosTable(storeDTO);
        log.info("storeDTO.getMember()11"+storeDTO);
        model.addAttribute("order", posTable1);
        log.info("posTable>>>>>>>>>>>>11"+posTable1);
        log.info("posTable>>>>>>>>>>>>11"+posTable1);
        posTableDTO.setPosTableNum(posTable1.getPosTableNum());
        log.info("posTableDTO..........>>11"+posTableDTO);
        posTableDTO.setStoreNum(storeDTO.getStoreNum());
        log.info("posTableDTO..........>>11"+posTableDTO);
        storeService.modify(posTableDTO, storeDTO);
    }
}