package com.ds.watchtable.service;

import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.dto.PosOrderDTO;
import com.ds.watchtable.entity.Pos;
import com.ds.watchtable.entity.PosOrder;
import com.ds.watchtable.entity.Store;

public interface PosOrderService {
    void posOrder(PosOrderDTO posOrderDTO);

    //    PosDTO getPos(Long mno);

    default PosOrder dtoToEntity(PosOrderDTO PosOrderDTO) {
        PosOrder posOrder = PosOrder.builder()
                .orderList(PosOrderDTO.getOrderList())
                .build();
        System.out.println(">>>>>>>>"+posOrder);
        return posOrder;
    }
    default PosOrderDTO entityToDTO(PosOrderDTO entity){
        PosOrderDTO posOrderDTO= PosOrderDTO.builder()
                .orderList(entity.getOrderList())
                .build();
        System.out.println(">>>>>>>>"+posOrderDTO);
        return posOrderDTO;
    }
}
