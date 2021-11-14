package com.ds.watchtable.controller;

import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.security.service.MemberDetailsService;
import com.ds.watchtable.security.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
public class LoginController {
//    @Autowired
//    private JWTUtil jwtUtil;
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/admin/**")
//    public void exAdmin(){
//        log.info("exAdmin....");
//    }
}
