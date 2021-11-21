package com.ds.watchtable.service;

import com.ds.watchtable.dto.*;
import com.ds.watchtable.entity.*;
import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface StoreService {

    //DB저장
    Long storeRegister(StoreDTO storeDTO);
    //admin/storelist 리스트 목록
    PageResultDTO<StoreDTO, Store> getLGHlist(PageRequestDTO requestDTO);
    //admin/storeread 가게 정보 상세보기
    StoreDTO getStore(Long storeNum);


    default Map<String, Object> dtoToEntity(StoreDTO storeDTO) {
        Map<String, Object> entityMap = new HashMap<>();
        Store store = Store.builder()
                .posTable(PosTable.builder()
                        .store(Store.builder()
                                .storeNum(storeDTO.getStoreNum())
                                .build())
                        .posTableNum(storeDTO.getPosTableNum())
                        .orderCount(storeDTO.getOrderCount())
                        .table1(storeDTO.getTable1())
                        .table2(storeDTO.getTable2())
                        .table3(storeDTO.getTable3())
                        .table4(storeDTO.getTable4())
                        .table5(storeDTO.getTable5())
                        .table6(storeDTO.getTable6())
                        .table7(storeDTO.getTable7())
                        .table8(storeDTO.getTable8())
                        .table9(storeDTO.getTable9())
                        .build())
                .member(Member.builder()
                        .memberNum(storeDTO.getMemberNum())
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
        store.addMemberRole(MemberRole.USER);

        List<StoreImageDTO> storeImageDTOList = storeDTO.getStoreImageDTOList();
        if (storeImageDTOList != null && storeImageDTOList.size() > 0) {
            List<StoreImage> storeImageList = storeImageDTOList.stream().map(storeImageDTO -> {
                StoreImage storeImage = StoreImage.builder()
                        .bsPath(storeImageDTO.getBsPath())
                        .bsImgName(storeImageDTO.getBsImgName())
                        .bsUuid(storeImageDTO.getBsUuid())
                        .store(store)
                        .build();
                System.out.printf(">>" + storeImage);
                return storeImage;
            }).collect(Collectors.toList());
            entityMap.put("storeImgList", storeImageList);
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
                System.out.printf(">>" + menuImage);
                return menuImage;
            }).collect(Collectors.toList());
            entityMap.put("menuImgList", menuImageList);
        }
        return entityMap;
    }

    default StoreDTO entityToDTO(Store store) {
        StoreDTO storeDTO = StoreDTO.builder()
                .storeNum(store.getStoreNum())
                .storeName(store.getStoreName())
                .storeAds(store.getStoreAds())
                .storeTel(store.getStoreTel())
                .storeText(store.getStoreText())
                .storeOpen(store.getStoreOpen())
                .storeClose(store.getStoreClose())
                .bsNum(store.getBsNum())
                .memberName(store.getMember().getMemberName())
                .regDate(store.getRegDate())
                .modDate(store.getModDate())
                .build();
        return storeDTO;
    }

    default StoreDTO storeEntityToDTO(Store store, List<StoreImage> storeImageList, List<MenuImage> menuImageList) {
        StoreDTO storeDTO = StoreDTO.builder()
                .storeNum(store.getStoreNum())
                .storeName(store.getStoreName())
                .storeAds(store.getStoreAds())
                .storeTel(store.getStoreTel())
                .storeText(store.getStoreText())
                .storeOpen(store.getStoreOpen())
                .storeClose(store.getStoreClose())
                .bsNum(store.getBsNum())
                .memberName(store.getMember().getMemberName())
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