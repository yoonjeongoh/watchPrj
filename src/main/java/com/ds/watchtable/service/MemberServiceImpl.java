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
        Member member = dtoToEntity(memberDTO);
        memberDTO.setMemberPw(this.passwordEncoder.encode(memberDTO.getMemberPw()));
        member.getMemberEmail();
        member.getMemberId();
        member.getMemberMobile();
        member.getMemberNum();
        member.getMemberNickname();
        member.getMemberName();
        member.isFromSocial();
        member.getRoleSet();
        memberRepository.save(member);
        log.info("member member" + member);
    }
}








