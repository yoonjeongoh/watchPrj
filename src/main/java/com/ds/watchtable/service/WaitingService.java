package com.ds.watchtable.service;

import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.dto.ReviewDTO;
import com.ds.watchtable.dto.WaitingDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Review;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.entity.Waiting;

import java.util.List;

public interface WaitingService {
    //DB저장
    Long registerWaiting(WaitingDTO waitingDTO);
    //웨이팅 리스트
    PageResultDTO<WaitingDTO, Waiting> getWaitingList(PageRequestDTO pageRequestDTO);
/*
    WaitingDTO getWaiting(Long waitingNum);
*/


        default Waiting dtoToEntity(WaitingDTO waitingDTO){
        Waiting waiting = Waiting.builder()
                .member(Member.builder()
                        .memberNum(waitingDTO.getMemberNum())
                        .memberId(waitingDTO.getMemberMobile())
                        .memberName(waitingDTO.getMemberName())
                        .memberNickname(waitingDTO.getMemberNickname())
                        .build())
                .store(Store.builder()
                        .storeNum(waitingDTO.getStoreNum())
                        .storeName(waitingDTO.getStoreName())
                        .build())
                .waitingNum(waitingDTO.getWaitingNum())
                .partyMember(waitingDTO.getPartyMember())
                .build();
            return waiting;
    }

    default WaitingDTO entityToDTO(Waiting waiting) {
        WaitingDTO waitingDTO = WaitingDTO.builder()
                .waitingNum(waiting.getWaitingNum())
                .partyMember(waiting.getPartyMember())
                .memberNum(waiting.getMember().getMemberNum())
                .memberName(waiting.getMember().getMemberName())
                .memberNickname(waiting.getMember().getMemberNickname())
                .memberMobile(waiting.getMember().getMemberMobile())
                .storeNum(waiting.getStore().getStoreNum())
                .storeName(waiting.getStore().getStoreName())
                .regDate(waiting.getRegDate())
                .modDate(waiting.getModDate())
                .build();
        return waitingDTO;
    }

}
