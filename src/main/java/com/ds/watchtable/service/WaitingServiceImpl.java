package com.ds.watchtable.service;

import com.ds.watchtable.dto.*;
import com.ds.watchtable.entity.*;
import com.ds.watchtable.repository.WaitingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class WaitingServiceImpl implements WaitingService{

    private final WaitingRepository waitingRepository;

    //DB저장
    @Override
    public Long registerWaiting(WaitingDTO waitingDTO) {
        Waiting waiting = dtoToEntity(waitingDTO);
        waitingRepository.save(waiting);
        log.info("savewaiting----"+waiting);
        return waiting.getWaitingNum();
    }

    //웨이팅 리스트
    @Override
    public PageResultDTO<WaitingDTO, Waiting> getWaitingList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("waitingNum").descending());
        log.info("----------waiting1111111-----------"+pageable);
        Page<Waiting> result = waitingRepository.findAll(pageable);
        log.info("----------waiting2222222-----------"+result);
        Function<Waiting, WaitingDTO> fn = (entity -> entityToDTO(entity));
        log.info("----------waiting3333333-----------"+fn);
        return new PageResultDTO<>(result, fn);
    }
/*
    @Override
    public PageResultDTO<WaitingDTO, Waiting> getWaitingList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("waitingNum").descending());
        log.info("----------waiting1111111-----------"+pageable);
        Page<Waiting> result = waitingRepository.getWaitingByStore(pageable);
        log.info("----------waiting2222222-----------"+result);
        Function<Waiting, WaitingDTO> fn = (entity -> entityToDTO(entity));
        log.info("----------waiting3333333-----------"+fn);
        return new PageResultDTO<>(result, fn);
    }
*/


//
//
//    //웨이팅 리스트 2
//    @Override
//    public WaitingDTO getWaiting(Long waitingNum) {
//        Waiting waiting = waitingRepository.getById(waitingNum);
//        log.info("----------waiting4444444-----------"+waiting);
//        log.info("----------waiting5555555-----------"+waitingNum);
//        return entityToDTO(waiting);
//    }


}
