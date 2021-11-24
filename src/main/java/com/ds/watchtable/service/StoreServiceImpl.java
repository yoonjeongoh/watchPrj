package com.ds.watchtable.service;

import com.ds.watchtable.dto.*;
import com.ds.watchtable.entity.*;
import com.ds.watchtable.repository.MenuImageRepository;
import com.ds.watchtable.repository.PosTableRepository;
import com.ds.watchtable.repository.StoreImageRepository;
import com.ds.watchtable.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    @Autowired
    final private StoreRepository storeRepository;
    @Autowired
    final private StoreImageRepository storeImageRepository;
    @Autowired
    final private MenuImageRepository menuImageRepository;
    @Autowired
    final private PosTableRepository posTableRepository;




    @Autowired
    private PasswordEncoder passwordEncoder;
    private StoreDTO storeDTO;

    //    DB저장
    @Transactional
    @Override
    public Long storeRegister(StoreDTO storeDTO) {
        log.info(">>>" + storeDTO);
        storeDTO.setMemberPw(passwordEncoder.encode(storeDTO.getMemberPw()));
        Map<String, Object> entityMap = dtoToEntity(storeDTO);
        Store store = (Store) entityMap.get("store");
        PosTable posTable = (PosTable) entityMap.get("posTable");
        log.info("오류오류" + store);
        List<StoreImage> storeImageList = (List<StoreImage>) entityMap.get("storeImgList");
        log.info("오류오류" + storeImageList);
        List<MenuImage> menuImageList = (List<MenuImage>) entityMap.get("menuImgList");
        log.info("오류오류" + menuImageList);
        storeRepository.save(store);
        storeImageList.forEach(storeImage -> {
            storeImageRepository.save(storeImage);
        });
        menuImageList.forEach(menuImage -> {
            menuImageRepository.save(menuImage);
        });
        posTableRepository.save(posTable);
        return store.getStoreNum();
    }

    //    admin store list
    @Override
    public PageResultDTO<StoreDTO, Store> getStoreList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("storeNum").descending());
        Page<Store> result = storeRepository.findAll(pageable);
        Function<Store, StoreDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO<>(result, fn);
    }

    //admin/storeread
    @Override
    public StoreDTO getStore(Long storeNum) {
        Store store = storeRepository.getById(storeNum);
        List<StoreImage> storeImageList = (List<StoreImage>) storeImageRepository.getStoreImageListByStoreNum(store);
        List<MenuImage> menuImageList = (List<MenuImage>) menuImageRepository.getMenuImageListByStoreNum(store);
        return storeEntityToDTO(store, storeImageList, menuImageList);
    }

    @Override
    public Store getStoreMember(Member member) {
        Store store = storeRepository.findByMember(member);
        store.getMember();
        log.info("yjyjyjyjyjyjyjyj"+store);
        return store;
    }

    @Override
    public PosTable getPosTable(Store store) {
        PosTable posTable = posTableRepository.findByPosTableToStore(store);
        log.info("yoonjeong posTable>>"+posTable);
        posTable.getPosTableNum();
        posTable.getTable1();
        posTable.getTable2();
        posTable.getTable3();
        posTable.getTable4();
        posTable.getTable5();
        posTable.getTable6();
        posTable.getTable7();
        posTable.getTable8();
        posTable.getTable9();
        posTable.getOrderCount();
        log.info("yoonjeong posTable>>"+posTable);
        return posTable;
    }

    @Override
    public void modify(PosTableDTO posTableDTO, Store store) {
        log.info("yoonjeong posTableDTO"+posTableDTO);
        PosTable posTable2 = posTableRepository.findByPosTableToStore(store);
        posTable2.getStore();
        PosTable posTable = PosTable.builder()
                .posTableNum(posTableDTO.getPosTableNum())
                .orderCount(posTableDTO.getOrderCount())
                .table1(posTableDTO.getTable1())
                .table2(posTableDTO.getTable2())
                .table3(posTableDTO.getTable3())
                .table4(posTableDTO.getTable4())
                .table5(posTableDTO.getTable5())
                .table6(posTableDTO.getTable6())
                .table7(posTableDTO.getTable7())
                .table8(posTableDTO.getTable8())
                .table9(posTableDTO.getTable9())
                .store(posTable2.getStore())
                .build();
        log.info("yoonjeong posTable"+posTable);
        posTableRepository.save(posTable);
    }
}