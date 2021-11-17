package com.ds.watchtable.service;


import com.ds.watchtable.dto.SettingDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Setting;
import com.ds.watchtable.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService {

    final private SettingRepository settingRepository;

    @Override
    public Long register(SettingDTO settingDTO) {
        log.info("impl1>>>"+settingDTO);
        Setting setting = dtoToEntity(settingDTO);
        log.info("impl2>>>"+settingDTO);
        settingRepository.save(setting);
        log.info("impl3>>>"+setting);
        return setting.getPosNum();

    }

    @Override
    public Setting getSetting(Long posNum) {
        Optional<Setting> result = settingRepository.findById(posNum);
        if (result.isPresent()) {
            Setting setting = result.get();
            return setting;
        }
        return null;
    }
}
