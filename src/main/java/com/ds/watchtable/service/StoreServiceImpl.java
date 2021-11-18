package com.ds.watchtable.service;

import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.MenuImage;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.entity.StoreImage;
import com.ds.watchtable.repository.MenuImageRepository;
import com.ds.watchtable.repository.StoreImageRepository;
import com.ds.watchtable.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private PasswordEncoder passwordEncoder;


    //    DB저장
    @Transactional
    @Override
    public Long storeRegister(StoreDTO storeDTO) {
        log.info(">>>" + storeDTO);
        storeDTO.setMemberPw(passwordEncoder.encode(storeDTO.getMemberPw()));
        Map<String, Object> entityMap = dtoToEntity(storeDTO);
        Store store = (Store) entityMap.get("store");
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
        return store.getStoreNum();
    }

    //    admin store list
    @Override
    public PageResultDTO<StoreDTO, Store> getLGHlist(PageRequestDTO requestDTO) {
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

/*
    //manager/managemyinfo
    @Override
    public Store getInfo(Long storeNum) {
        Optional<Store> result = storeRepository.findById(storeNum);
        if (result.isPresent()) {
            Store store = result.get();
            return store;
        }
        return null;
    }
*/



}