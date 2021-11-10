package com.ds.watchtable.service;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    final private MemberRepository memberRepository;

    //db 저장
    @Override
    public String register(MemberDTO memberDTO) {
        Member member = dtoToEntity(memberDTO);
        memberRepository.save(member); //save: 저장, 수정
        return member.getMemberName();
    }
}

// ------ 삽질 샤따내립니다 -----------------------------------------------------

//    @Override
//    public MemberDTO get(Long memberNum) {
//        Optional<Member> result = memberRepository.findById(memberNum);
////        Optional<Member> result = memberRepository.findById(Math.toIntExact(memberNum));
//        return result.isPresent()?entityToDTO(result.get()):"null";
//    }

//    @Override
//    public MemberDTO get(int memberNum) {
//        List<Object[]> result = memberRepository.findAll();
//
//        return entityToDTO(member);
//    }

    //    @Override
//    public User add(User user) throws Exception {
//        return userRepository.save(user);
//    }


