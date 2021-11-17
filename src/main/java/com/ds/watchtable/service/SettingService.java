package com.ds.watchtable.service;

import com.ds.watchtable.dto.SettingDTO;
import com.ds.watchtable.entity.Setting;

public interface SettingService {

    Long storeSetting(SettingDTO settingDTO);

    default Setting dtoToEntity(SettingDTO settingDTO){
        Setting storeTable = Setting.builder()
                .tableNum(settingDTO.getStoreTableNum())
                .tableTwo(settingDTO.getTableTwo())
                .tableFour(settingDTO.getTableFour())
                .tableSix(settingDTO.getTableSix())
                .build();
        return storeTable;
    }

    default SettingDTO entityToDTO(Setting storeTable){
        SettingDTO settingDTO = SettingDTO.builder()
                .storeTableNum(storeTable.getTableNum())
                .tableTwo(storeTable.getTableTwo())
                .tableFour(storeTable.getTableFour())
                .tableSix(storeTable.getTableSix())
                .modDate(storeTable.getModDate())
                .regDate(storeTable.getRegDate())
                .build();
        return settingDTO;
    }
}