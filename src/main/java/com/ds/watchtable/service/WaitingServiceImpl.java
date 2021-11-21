package com.ds.watchtable.service;

import com.ds.watchtable.dto.ReviewDTO;
import com.ds.watchtable.dto.WaitingDTO;
import com.ds.watchtable.entity.Review;
import com.ds.watchtable.entity.Waiting;
import com.ds.watchtable.repository.WaitingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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


}
