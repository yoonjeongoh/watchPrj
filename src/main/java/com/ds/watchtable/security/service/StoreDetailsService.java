package com.ds.watchtable.security.service;

import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.PosTable;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.repository.StoreRepository;
import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class StoreDetailsService {

    private final StoreRepository storeRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("ClubUserDetailsService loadUserByMemberId=" + username);
//        Optional<Member> result = storeRepository.findByMemberId(username,false);
//        if (!result.isPresent()) {
//            throw new UsernameNotFoundException("Check User Email or from Social ");
//        }
//        PosTable posTable= result.get();
//        log.info("-----------------------------");
//
//
//        ClubAuthMemberDTO clubAuthMemberDTO = new ClubAuthMemberDTO(
//                posTable.getStoreName(),
//                posTable.getMemberPw(),
//                posTable.isFromSocial(),
//                posTable.getRoleSet().stream()
//                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.()))
//                        .collect(Collectors.toSet())
//        );
//        clubAuthMemberDTO.setMember(store);
//        return clubAuthMemberDTO;
//    }
}
