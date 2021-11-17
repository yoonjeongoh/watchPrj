package com.ds.watchtable.service;

import com.ds.watchtable.dto.SettingDTO;
import com.ds.watchtable.entity.Setting;

public interface SettingService {

Long register(SettingDTO settingDTO);

    default Setting dtoToEntity(SettingDTO settingDTO){
        Setting setting = Setting.builder()
                .posNum(settingDTO.getPosNum())
                .tableTwo(settingDTO.getTableTwo())
                .tableFour(settingDTO.getTableFour())
                .tableSix(settingDTO.getTableSix())
                .build();
        return setting;
    }

    default SettingDTO entityToDTO(Setting setting){
        SettingDTO settingDTO = SettingDTO.builder()
                .posNum(setting.getPosNum())
                .tableTwo(setting.getTableTwo())
                .tableFour(setting.getTableFour())
                .tableSix(setting.getTableSix())
                .modDate(setting.getModDate())
                .regDate(setting.getRegDate())
                .build();
        return settingDTO;
    }
}