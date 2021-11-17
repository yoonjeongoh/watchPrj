package com.ds.watchtable.service;

import com.ds.watchtable.dto.StoreOrderDTO;
import com.ds.watchtable.entity.StoreOrder;

public interface StoreOrderService {
    default StoreOrder dtoToEntity(StoreOrderDTO storeOrderDTO){
        StoreOrder storeOrder = StoreOrder.builder()
                .storeOrderNum(storeOrderDTO.getStoreOrderNum())
                .storeOrderList(storeOrderDTO.getStoreOrderList())
                .build();
        return storeOrder;
    }

    default StoreOrderDTO entityToDTO(StoreOrder storeOrder){
        StoreOrderDTO storeOrderDTO = StoreOrderDTO.builder()
                .storeOrderNum(storeOrder.getStoreOrderNum())
                .storeOrderList(storeOrder.getStoreOrderList())
                .build();
        return storeOrderDTO;
    }
}
