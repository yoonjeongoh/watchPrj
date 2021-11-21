package com.ds.watchtable.service;

import com.ds.watchtable.dto.PosTableDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.PosTable;
import com.ds.watchtable.entity.Store;

import java.util.HashMap;
import java.util.Map;

public interface PosTableService {

    PosTableDTO getPosTable(Long posTableDTO);

    default PosTable dtoToEntity(PosTableDTO posTableDTO) {
        Map<String, Object> entityMap = new HashMap<>();
        PosTable posTable = PosTable.builder()
                .member(Member.builder()
                        .memberNum(posTableDTO.getMemberNum())
                        .memberName(posTableDTO.getMemberName())
                        .memberNickname(posTableDTO.getMemberNickname())
                        .memberId(posTableDTO.getMemberId())
                        .memberEmail(posTableDTO.getMemberEmail())
                        .memberPw(posTableDTO.getMemberPw())
                        .memberMobile(posTableDTO.getMemberMobile())
                        .build())
                .store(Store.builder()
                        .storeNum(posTableDTO.getStoreNum())
                        .storeName(posTableDTO.getStoreName())
                        .storeAds(posTableDTO.getStoreAds())
                        .storeTel(posTableDTO.getStoreTel())
                        .storeText(posTableDTO.getStoreText())
                        .storeOpen(posTableDTO.getStoreOpen())
                        .storeClose(posTableDTO.getStoreClose())
                        .bsNum(posTableDTO.getBsNum())
                        .build())
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
                .build();
        entityMap.put("posTable", posTable);
        return posTable;
    }
    default PosTableDTO entityToDTO(PosTable posTable) {
        PosTableDTO posTableDTO = PosTableDTO.builder()
                .posTableNum(posTable.getPosTableNum())
                .orderCount(posTable.getOrderCount())
                .table1(posTable.getTable1())
                .table2(posTable.getTable2())
                .table3(posTable.getTable3())
                .table4(posTable.getTable4())
                .table5(posTable.getTable5())
                .table6(posTable.getTable6())
                .table7(posTable.getTable7())
                .table8(posTable.getTable8())
                .table9(posTable.getTable9())
                .storeNum(posTable.getStore().getStoreNum())
                .build();
        return posTableDTO;
    }
}
