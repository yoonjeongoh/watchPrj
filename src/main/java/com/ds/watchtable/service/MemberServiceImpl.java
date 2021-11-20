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

    @Override
    public void modify(MemberDTO memberDTO) {
        Optional<Member> result = memberRepository.findById(memberDTO.getMemberNum());
        if (result.isPresent()) {
            Member member = result.get();
            member.changeName(memberDTO.getMemberName());
            member.changeNickname(memberDTO.getMemberNickname());
            member.changeMobile(memberDTO.getMemberMobile());
            member.getMemberPw();
            member.getRoleSet();
            member.getMemberNum();
            member.getMemberEmail();
            memberRepository.save(member);
        }
    }
}







