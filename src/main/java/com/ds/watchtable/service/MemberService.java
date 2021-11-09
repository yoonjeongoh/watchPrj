package com.ds.watchtable.service;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;

public interface MemberService {
//    public User add(User user) throws Exception;

    String register(MemberDTO dto);

    default Member dtoToEntity(MemberDTO memberDTO){
        Member member = Member.builder()
                .memberNum(memberDTO.getMemberNum())
                .memberName(memberDTO.getMemberName())
                .memberNickname(memberDTO.getMemberNickname())
                .type(memberDTO.getType())
                .memberId(memberDTO.getMemberId())
                .memberEmail(memberDTO.getMemberEmail())
                .memberMobile(memberDTO.getMemberMobile())
                .memberPw(memberDTO.getMemberPw())
                .build();
        return member;
    }


    default MemberDTO entityToDTO(Member member){
        MemberDTO memberDTO = MemberDTO.builder()
                .memberNum(member.getMemberNum())
                .memberName(member.getMemberName())
                .memberId(member.getMemberId())
                .memberEmail(member.getMemberEmail())
                .memberMobile(member.getMemberMobile())
                .memberPw(member.getMemberPw())
                .modDate(member.getModDate())
                .regDate(member.getRegDate())
                .build();
        return memberDTO;
    }

}
