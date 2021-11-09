package com.ds.watchtable.service;

import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.dto.StoreImageDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.entity.StoreImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface StoreService {

    int storeRegister(StoreDTO storeDTO);

    default Map<String, Object> dtoToEntity(StoreDTO storeDTO) {
        Map<String, Object> entityMap = new HashMap<>();
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
        entityMap.put("store", store);

        List<StoreImageDTO> imageDTOList = storeDTO.getImageDTOList();
        if (imageDTOList != null && imageDTOList.size() > 0) {
            List<StoreImage> storeImageList = imageDTOList.stream().map(storeImageDTO -> {
                StoreImage storeImage = StoreImage.builder()
                        .path(storeImageDTO.getPath())
                        .imgName(storeImageDTO.getImgName())
                        .uuid(storeImageDTO.getUuid())
                        .store(store)
                        .build();
                return storeImage;
            }).collect(Collectors.toList());
            entityMap.put("imgList",storeImageList);
        }
        return entityMap;
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

    default StoreDTO entityToDTO(Store store, List<StoreImage> storeImageList) {
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

        List<StoreImageDTO> storeImageDTOList = storeImageList.stream()
                .map(storeImage -> {
                    return StoreImageDTO.builder().imgName(storeImage.getImgName())
                            .path(storeImage.getPath())
                            .uuid(storeImage.getUuid())
                            .build();
                }).collect(Collectors.toList());
        storeDTO.setImageDTOList(storeImageDTOList);

        return storeDTO;
    }
}