package com.ds.watchtable.service;

import com.ds.watchtable.dto.SettingDTO;
import com.ds.watchtable.entity.Setting;

public interface SettingService {

    void storeSetting(SettingDTO settingDTO);

    default Setting dtoToEntity(SettingDTO settingDTO){
        Setting setting = Setting.builder()
                .storeTableNum(settingDTO.getStoreTableNum())
                .tableTwo(settingDTO.getTableTwo())
                .tableFour(settingDTO.getTableFour())
                .tableSix(settingDTO.getTableSix())
                .build();
        return setting;
    }

    default SettingDTO entityToDTO(Setting storeTable){
        SettingDTO settingDTO = SettingDTO.builder()
                .storeTableNum(storeTable.getStoreTableNum())
                .tableTwo(storeTable.getTableTwo())
                .tableFour(storeTable.getTableFour())
                .tableSix(storeTable.getTableSix())
                .modDate(storeTable.getModDate())
                .regDate(storeTable.getRegDate())
                .build();
        return settingDTO;
    }
}