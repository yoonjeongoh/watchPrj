package com.ds.watchtable.security.service;

import com.ds.watchtable.entity.Member;
import com.ds.watchtable.repository.MemberRepository;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        log.info("ClubUserDetailsService loadUserByMemberId=" + memberId);
        Optional<Member> result = memberRepository.findByMemberId(memberId, false);
        if (!result.isPresent()) {
            throw new UsernameNotFoundException("Check User Email or from Social ");
        }
        Member member = result.get();
        log.info("-----------------------------");
        log.info(member);
        ClubAuthMemberDTO clubAuthMemberDTO = new ClubAuthMemberDTO(
                member.getMemberId(),
                member.getMemberPw(),
                member.isFromSocial(),
                member.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                        .collect(Collectors.toSet())
        );
        clubAuthMemberDTO.setName(member.getMemberName());
        clubAuthMemberDTO.setFromSocial(member.isFromSocial());
        return clubAuthMemberDTO;
    }
}
