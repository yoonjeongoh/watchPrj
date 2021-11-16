package com.ds.watchtable.service;

import com.ds.watchtable.dto.PosOrderDTO;
import com.ds.watchtable.entity.*;
import com.ds.watchtable.repository.PosOrderRepository;
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
public class PosOrderServiceImpl implements PosOrderService{
    final private PosOrderRepository posOrderRepository;

    @Transactional
    @Override
    public void posOrder(PosOrderDTO posOrderDTO) {
        PosOrder posorder = dtoToEntity(posOrderDTO);
        posOrderRepository.save(posorder);
    }

    //데이터 불러오기
    @Override
    public PosOrder getPosOrder(Long orderNum) {
        Optional<PosOrder> result = posOrderRepository.findById(orderNum);
        if (result.isPresent()) {
            PosOrder posOrder = result.get();
            return posOrder;
        }
        return null;
    }


}
