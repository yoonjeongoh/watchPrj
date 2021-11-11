package com.ds.watchtable.service;

import com.ds.watchtable.dto.MenuImageDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.dto.StoreImageDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.MenuImage;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.entity.StoreImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface StoreService {

    Long storeRegister(StoreDTO storeDTO);

    default Map<String, Object> dtoToEntity(StoreDTO storeDTO) {
        Map<String, Object> entityMap = new HashMap<>();
        Store store = Store.builder()
                .member(Member.builder().memberNum(storeDTO.getMemberNum())
                        .memberName(storeDTO.getMemberName())
                        .memberNickname(storeDTO.getMemberNickname())
                        .memberId(storeDTO.getMemberId())
                        .memberEmail(storeDTO.getMemberEmail())
                        .memberPw(storeDTO.getMemberPw())
                        .memberMobile(storeDTO.getMemberMobile())
                        .build())
                .storeNum(storeDTO.getStoreNum())
                .storeName(storeDTO.getStoreName())
                .storeAds(storeDTO.getStoreAds())
                .storeTel(storeDTO.getStoreTel())
                .storeText(storeDTO.getStoreText())
                .storeOpen(storeDTO.getStoreOpen())
                .storeClose(storeDTO.getStoreClose())
                .bsNum(storeDTO.getBsNum())
                .build();
        entityMap.put("store", store);

        List<StoreImageDTO> storeImageDTOList = storeDTO.getStoreImageDTOList();
        if (storeImageDTOList != null && storeImageDTOList.size() > 0) {
            List<StoreImage> storeImageList = storeImageDTOList.stream().map(storeImageDTO -> {
                StoreImage storeImage = StoreImage.builder()
                        .bsPath(storeImageDTO.getBsPath())
                        .bsImgName(storeImageDTO.getBsImgName())
                        .bsUuid(storeImageDTO.getBsUuid())
                        .store(store)
                        .build();
                System.out.printf(">>"+storeImage);
                return storeImage;
            }).collect(Collectors.toList());
            entityMap.put("storeImgList",storeImageList);
        }
        List<MenuImageDTO> menuImageDTOList = storeDTO.getMenuImageDTOList();
        if (menuImageDTOList != null && menuImageDTOList.size() > 0) {
            List<MenuImage> menuImageList = menuImageDTOList.stream().map(menuImageDTO -> {
                MenuImage menuImage = MenuImage.builder()
                        .menuPath(menuImageDTO.getMenuPath())
                        .menuImgName(menuImageDTO.getMenuImgName())
                        .menuUuid(menuImageDTO.getMenuUuid())
                        .store(store)
                        .build();
                System.out.printf(">>"+menuImage);
                return menuImage;
            }).collect(Collectors.toList());
            entityMap.put("menuImgList",menuImageList);
        }
        return entityMap;
    }

    default StoreDTO entityToDTO(Store store, List<StoreImage> storeImageList, List<MenuImage> menuImageList) {
        StoreDTO storeDTO = StoreDTO.builder()
                .storeNum(store.getStoreNum())
                .storeName(store.getStoreName())
                .storeAds(store.getStoreAds())
                .storeTel(store.getStoreTel())
                .storeText(store.getStoreText())
                .storeOpen(store.getStoreOpen())
                .storeClose(store.getStoreClose())
                .bsNum(store.getBsNum())
                .regDate(store.getRegDate())
                .modDate(store.getModDate())
                .build();

        List<StoreImageDTO> storeImageDTOList = storeImageList.stream()
                .map(storeImage -> {
                    return StoreImageDTO.builder()
                            .bsImgName(storeImage.getBsImgName())
                            .bsPath(storeImage.getBsPath())
                            .bsUuid(storeImage.getBsUuid())
                            .build();
                }).collect(Collectors.toList());
        storeDTO.setStoreImageDTOList(storeImageDTOList);

        List<MenuImageDTO> menuImageDTOList = menuImageList.stream()
                .map(menuImage -> {
                    return MenuImageDTO.builder()
                            .menuImgName(menuImage.getMenuImgName())
                            .menuPath(menuImage.getMenuPath())
                            .menuUuid(menuImage.getMenuUuid())
                            .build();
                }).collect(Collectors.toList());
        storeDTO.setMenuImageDTOList(menuImageDTOList);

        return storeDTO;
    }
}