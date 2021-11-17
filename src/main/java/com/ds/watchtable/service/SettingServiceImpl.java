package com.ds.watchtable.service;


import com.ds.watchtable.dto.SettingDTO;
import com.ds.watchtable.entity.Setting;
import com.ds.watchtable.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {
    @Autowired
    final private SettingRepository settingRepository;

    @Override
    public Long storeSetting(SettingDTO settingDTO) {
        Setting setting = dtoToEntity(settingDTO);
        settingRepository.save(setting);
        return setting.getTableNum();
    }

}