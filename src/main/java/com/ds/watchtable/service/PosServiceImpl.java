package com.ds.watchtable.service;

import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.entity.Pos;
import com.ds.watchtable.repository.PosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class PosServiceImpl implements PosService{
    final private PosRepository posRepository;

    @Transactional
    @Override
    public void posSetting(PosDTO posDTO) {
        Pos pos = dtoToEntity(posDTO);
        posRepository.save(pos);
    }

    @Override
    public PosDTO list(Long posNum){
        Optional<Pos> result = posRepository.findById(posNum);
        return result.isPresent()?entityToDTO(result.get()):null;
    }

//    @Override
//    public PosDTO getPos(Long posNum) {
//        List<Object[]> result = posRepository.getPosAll(posNum);
//        Pos pos = (Pos) result.get(0)[0];
//        return entityToDTO(pos);
//    }


}
