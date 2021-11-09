package com.ds.watchtable.service;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Pos;
import com.ds.watchtable.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ds.watchtable.entity.QMember.member;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    final private MemberRepository memberRepository;

    @Override
    public String register(MemberDTO memberDTO) {
        Member member = dtoToEntity(memberDTO);
        memberRepository.save(member); //저장, 수정
        return member.getMemberName();
    }

    @Override
    public MemberDTO getInfo(int memberNum) {
        Optional<Member> result = memberRepository.findById(memberNum);
        return result.isPresent()?entityToDTO(result.get()):null;
    }

//    @Override
//    public MemberDTO getInfo(int memberNum) {
//        List<Object[]> result = memberRepository.findAll();
//
//        return entityToDTO(member);
//    }

    //    @Override
//    public User add(User user) throws Exception {
//        return userRepository.save(user);
//    }

}
