package com.ds.watchtable.controller;

import com.ds.watchtable.security.dto.ClubAuthMemberDTO;
import com.ds.watchtable.security.service.MemberDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
public class LoginController {

  private final MemberDetailsService clubUserDetailsService;
  private final PasswordEncoder passwordEncoder;

  @PostMapping("member/login")
  public String loginForm(String username, String password){
    String resultUrl = "";
    log.info("custom login................");
    ClubAuthMemberDTO clubAuthMemberDTO = (ClubAuthMemberDTO)
            clubUserDetailsService.loadUserByUsername(username);
    log.info("clubAuthMemberDTO: "+ clubAuthMemberDTO);
    boolean passwordResult = passwordEncoder.matches(
            password, clubAuthMemberDTO.getPassword());
    if (passwordResult) {
      resultUrl = "redirect:/";
    } else {
      resultUrl = "redirect:/member/posmyinfo";
    }
    return resultUrl;
  }

}
