package com.ds.watchtable.service;

import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.repository.MemberRepository;
import com.ds.watchtable.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
    final private StoreRepository storeRepository;
    final private MemberRepository memberRepository;

    @Override
    public void storeRegister(StoreDTO storeDTO) {
        Store store = dtoToEntity(storeDTO);
        Member member = dtoToEntity2(storeDTO);
        storeRepository.save(store);
        memberRepository.save(member);
    }
}
