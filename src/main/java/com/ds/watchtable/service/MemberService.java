package com.ds.watchtable.service;


import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.PosDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.MemberRole;

import java.util.List;

public interface MemberService {
//    public User add(User user) throws Exception;

    String register(MemberDTO dto);
//    MemberDTO list(Long memberDTO);
//    MemberDTO get(Long memberNum);
//    public void get(Member member);
//    public List<MemberDTO> getAll();


    default Member dtoToEntity(MemberDTO memberDTO){
        Member member = Member.builder()
                .memberNum(memberDTO.getMemberNum())
                .memberName(memberDTO.getMemberName())
                .memberNickname(memberDTO.getMemberNickname())
                .memberId(memberDTO.getMemberId())
                .memberEmail(memberDTO.getMemberEmail())
                .memberMobile(memberDTO.getMemberMobile())
                .memberPw(memberDTO.getMemberPw())
                .build();
        member.addMemberRole(MemberRole.USER);
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
                .roleSet(member.getRoleSet())
                .build();
        return memberDTO;
    }

}
