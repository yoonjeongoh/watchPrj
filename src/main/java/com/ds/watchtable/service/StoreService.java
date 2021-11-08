package com.ds.watchtable.service;

import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Store;

public interface StoreService {

    void storeRegister(StoreDTO storeDTO);

    default Store dtoToEntity(StoreDTO storeDTO){
        Store store = Store.builder()
                .member(Member.builder().memberNum(storeDTO.getMemberNum())
                        .memberName(storeDTO.getMemberName())
                        .memberNickname(storeDTO.getMemberNickname())
                        .memberId(storeDTO.getMemberId())
                        .memberEmail(storeDTO.getMemberEmail())
                        .memberPw(storeDTO.getMemberPw())
                        .type(storeDTO.getType())
                        .memberMobile(storeDTO.getMemberMobile())
                        .build())
                .storeNum(storeDTO.getStoreNum())
                .storeName(storeDTO.getStoreName())
                .storeMenu(storeDTO.getStoreMenu())
                .storeAds(storeDTO.getStoreAds())
                .storeTel(storeDTO.getStoreTel())
                .storeText(storeDTO.getStoreText())
                .storeOpen(storeDTO.getStoreOpen())
                .storeClose(storeDTO.getStoreClose())
                .bsNum(storeDTO.getBsNum())
                .bsImg(storeDTO.getBsImg())
                .build();
        return store;
    }

//    default Member dtoToEntity2(StoreDTO storeDTO){
//        Member member = Member.builder()
//                .memberNum(storeDTO.getMemberNum())
//                .memberName(storeDTO.getMemberName())
//                .memberId(storeDTO.getMemberId())
//                .memberEmail(storeDTO.getMemberEmail())
//                .memberNickname(storeDTO.getMemberNickname())
//                .memberPw(storeDTO.getMemberPw())
//                .type(storeDTO.getType())
//                .memberMobile(storeDTO.getMemberMobile())
//                .build();
//        return member;
//    }

    default StoreDTO entityToDTO(Store store){
        StoreDTO storeDTO = StoreDTO.builder()
                .storeNum(store.getStoreNum())
                .storeName(store.getStoreName())
                .storeMenu(store.getStoreMenu())
                .storeAds(store.getStoreAds())
                .storeTel(store.getStoreTel())
                .storeText(store.getStoreText())
                .storeOpen(store.getStoreOpen())
                .storeClose(store.getStoreClose())
                .bsNum(store.getBsNum())
                .bsImg(store.getBsImg())
                .regDate(store.getRegDate())
                .modDate(store.getModDate())
                .build();
        return storeDTO;
    }
}
