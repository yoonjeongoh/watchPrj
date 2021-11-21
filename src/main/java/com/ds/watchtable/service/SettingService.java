/*
package com.ds.watchtable.service;

import com.ds.watchtable.dto.SettingDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Setting;

public interface SettingService {

Long register(SettingDTO settingDTO);

SettingDTO getSetting(Long posNum);

    default Setting dtoToEntity(SettingDTO settingDTO){
        Setting setting = Setting.builder()
                .posNum(settingDTO.getPosNum())
                .tableNum(settingDTO.getTableNum())
                .size(settingDTO.getSize())
                .build();
        return setting;
    }

    default SettingDTO entityToDTO(Setting setting){
        SettingDTO settingDTO = SettingDTO.builder()
                .posNum(setting.getPosNum())
                .tableNum(setting.getTableNum())
                .size(setting.getSize())
                .modDate(setting.getModDate())
                .regDate(setting.getRegDate())
                .build();
        return settingDTO;
    }
}*/
