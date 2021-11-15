package com.ds.watchtable.service;

import com.ds.watchtable.dto.PosOrderDTO;
import com.ds.watchtable.entity.PosOrder;
import com.ds.watchtable.repository.PosOrderRepository;
import com.ds.watchtable.repository.PosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class PosOrderServiceImpl implements PosOrderService{
    final private PosOrderRepository posOrderRepository;

    @Transactional
    @Override
    public void posOrder(PosOrderDTO posOrderDTO) {
        PosOrder posorder = dtoToEntity(posOrderDTO);
        posOrderRepository.save(posorder);
    }
}
