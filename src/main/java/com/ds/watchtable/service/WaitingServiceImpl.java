package com.ds.watchtable.service;

import com.ds.watchtable.dto.*;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Review;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.entity.Waiting;
import com.ds.watchtable.repository.WaitingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

    //웨이팅 리스트 (사업자)
    @Override
    public PageResultDTO<WaitingDTO, Waiting> getWaitingList(PageRequestDTO requestDTO, Store store) {
        Pageable pageable = requestDTO.getPageable(Sort.by("waitingNum").ascending());
        Page<Waiting> result = waitingRepository.getWaitingByStore(pageable, store);
        Function<Waiting, WaitingDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO<>(result, fn);
    }

    //웨이팅리스트 (유저)
    @Override
    public PageResultDTO<WaitingDTO, Waiting> getUserWaiting(PageRequestDTO requestDTO, Member member) {
        Pageable pageable = requestDTO.getPageable(Sort.by("waitingNum").ascending());
        log.info("----------waiting1111111-----------"+pageable);
        Page<Waiting> result = waitingRepository.getWaitingByUser(pageable, member);
        log.info("----------waiting2222222-----------"+result);
        Function<Waiting, WaitingDTO> fn = (entity -> entityToDTO(entity));
        log.info("----------waiting3333333-----------"+fn);
        return new PageResultDTO<>(result, fn);
    }

    //웨이팅 수정
    @Override
    public void modify(WaitingDTO waitingDTO) {
        Optional<Waiting> result =
                waitingRepository.findById(waitingDTO.getWaitingNum());
        if(result.isPresent()) {
            Waiting waiting = result.get();
            log.info(">>>>>>>>waiting4444<<<<<<<"+result);
            waiting.changePartyMember(waitingDTO.getPartyMember());
            waitingRepository.save(waiting);
        }
    }


}
