package com.ds.watchtable.security.service;

import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.MemberRole;
import com.ds.watchtable.repository.MemberRepository;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ClubOAuth2UserDetailsService extends DefaultOAuth2UserService {

    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("----------------------");
        log.info("userRequest: " + userRequest);
        String clientName = userRequest.getClientRegistration().getClientName();
        log.info("clientName: " + clientName);
        log.info(userRequest.getAdditionalParameters());
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("===================================");
        oAuth2User.getAttributes().forEach(new BiConsumer<String, Object>() {
            @Override
            public void accept(String k, Object v) {
                log.info(k + ":" + v);
            }
        });
        String email = null;
        if (clientName.equals("Google")) {
            email = oAuth2User.getAttribute("email");
        }
        log.info("EMAIL: " + email);
        Member member = saveSocialMember(email);
//    return oAuth2User;
        ClubAuthMemberDTO clubAuthMemberDTO = new ClubAuthMemberDTO(
                member.getMemberId(),
                member.getMemberPw(),
                true,
                member.getRoleSet().stream().map(
                        role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                        .collect(Collectors.toList()), oAuth2User.getAttributes());
        clubAuthMemberDTO.setName(member.getMemberName());
        clubAuthMemberDTO.setMember(member);
        return clubAuthMemberDTO;
    }

    private Member saveSocialMember(String memberId) {
        Optional<Member> result = repository.findByMemberId(memberId, true);
        if (result.isPresent()) return result.get(); //있으면 끝
        Member member = Member.builder()
                .memberId(memberId)
                .memberName(memberId)
                .memberPw(passwordEncoder.encode("1"))
                .fromSocial(true)
                .build();
        member.addMemberRole(MemberRole.USER);
        repository.save(member);
        return member;
    }
}
