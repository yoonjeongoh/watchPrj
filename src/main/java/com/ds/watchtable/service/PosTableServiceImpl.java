package com.ds.watchtable.service;

import com.ds.watchtable.dto.PosTableDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.PosTable;
import com.ds.watchtable.repository.PosTableRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PosTableServiceImpl implements PosTableService{
    private PosTableRepository posTableRepository;

    @Override
    public Long add(PosTableDTO posTableDTO) {
        PosTable posTable = dtoToEntity(posTableDTO);
        posTableRepository.save(posTable);
        return posTable.getPosTableNum();
    }
}
