package com.ds.watchtable.service;

import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.MenuImage;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.entity.StoreImage;
import com.ds.watchtable.repository.MenuImageRepository;
import com.ds.watchtable.repository.StoreImageRepository;
import com.ds.watchtable.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
    @Autowired
    final private StoreRepository storeRepository;
    @Autowired
    final private StoreImageRepository storeImageRepository;
    @Autowired
    final private MenuImageRepository menuImageRepository;


    @Transactional
    @Override
    public Long storeRegister(StoreDTO storeDTO) {
        log.info(">>>"+storeDTO);
        Map<String, Object> entityMap = dtoToEntity(storeDTO);
        Store store = (Store) entityMap.get("store");
        log.info("오류오류"+store);
        List<StoreImage> storeImageList = (List<StoreImage>) entityMap.get("storeImgList");
        log.info("오류오류"+storeImageList);
        List<MenuImage> menuImageList = (List<MenuImage>) entityMap.get("menuImgList");
        log.info("오류오류"+menuImageList);
        storeRepository.save(store);
        storeImageList.forEach(storeImage -> {
            storeImageRepository.save(storeImage);
        });
        menuImageList.forEach(menuImage -> {
            menuImageRepository.save(menuImage);
        });
        return store.getStoreNum();
    }
}