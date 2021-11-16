package com.ds.watchtable.service;

import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.dto.PosOrderDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Pos;
import com.ds.watchtable.entity.PosOrder;
import com.ds.watchtable.entity.Store;

public interface PosOrderService {
    void posOrder(PosOrderDTO posOrderDTO);

    PosOrder getPosOrder(Long orderNum);
    //    PosDTO getPos(Long mno);

    default PosOrder dtoToEntity(PosOrderDTO PosOrderDTO) {
        PosOrder posOrder = PosOrder.builder()
                .order1(PosOrderDTO.getOrder1())
                .order2(PosOrderDTO.getOrder2())
                .order3(PosOrderDTO.getOrder3())
                .order4(PosOrderDTO.getOrder4())
                .drink1(PosOrderDTO.getDrink1())
                .drink2(PosOrderDTO.getDrink2())
                .orderNum1(PosOrderDTO.getOrderNum1())
                .orderNum2(PosOrderDTO.getOrderNum2())
                .orderNum3(PosOrderDTO.getOrderNum3())
                .orderNum4(PosOrderDTO.getOrderNum4())
                .drinkNum1(PosOrderDTO.getDrinkNum1())
                .drinkNum2(PosOrderDTO.getDrinkNum2())
                .build();
        System.out.println(">>>>>>>>"+posOrder);
        return posOrder;
    }
    default PosOrderDTO entityToDTO(PosOrderDTO entity){
        PosOrderDTO posOrderDTO= PosOrderDTO.builder()
                .order1(entity.getOrder1())
                .order2(entity.getOrder2())
                .order3(entity.getOrder3())
                .order4(entity.getOrder4())
                .drink1(entity.getDrink1())
                .drink2(entity.getDrink2())
                .orderNum1(entity.getOrderNum1())
                .orderNum2(entity.getOrderNum2())
                .orderNum3(entity.getOrderNum3())
                .orderNum4(entity.getOrderNum4())
                .drinkNum1(entity.getDrinkNum1())
                .drinkNum2(entity.getDrinkNum2())
                .build();
        System.out.println(">>>>>>>>"+posOrderDTO);
        return posOrderDTO;
    }
}
