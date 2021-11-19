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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping
public class LoginController {
    @GetMapping("/join/login")
    public void login(String error, String logout, Model model) {
        log.info("login error : "+error);
        log.info("login logout : "+logout);
        if (error != null){
            model.addAttribute("error","Login Error Check Your Account");
        }
        if (logout != null){
            model.addAttribute("logout","Logout!");
        }
    }
}
