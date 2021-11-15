package com.ds.watchtable.service;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    final private MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //db 저장
    @Override
    public String register(MemberDTO memberDTO) {
        memberDTO.setMemberPw(this.passwordEncoder.encode(memberDTO.getMemberPw()));
        Member member = dtoToEntity(memberDTO);
        memberRepository.save(member);
        return member.getMemberName();
    }
    //옵셔널은 하나만 가져오는것
    @Override
    public Member getInfo(Long memberNum) {
        Optional<Member> result = memberRepository.findById(memberNum);
        if (result.isPresent()) {
            Member member = result.get();
            return member;
        }
        return null;
    }



}


    //그냥 다 틀려먹었다고 tlqkf
//    @Override
//    public List<MemberDTO> getAll() {
//        List<Member> list = memberRepository.findAll();
//        List<MemberDTO> dtoList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            MemberDTO dto = entityToDTO(list.get(i));
//            dtoList.add(dto);
//        }
//        return dtoList;
//    }
//

//    @Override
//    public List<MemberDTO> getInfo(Long memberNum) {
//        List<Member> = memberRepository.findById(memberNum);
//        return entityToDTO(member);
//    }




