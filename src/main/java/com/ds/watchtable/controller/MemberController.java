package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.repository.MemberRepository;
import com.ds.watchtable.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private final MemberService memberService;

    //
//    @PostMapping("{usernum}")
//    public ResponseEntity<Integer> addUser(@RequestBody UserDTO userDTO){
//        log.info("----------add user--");
//        log.info("userDTO-------- : "+userDTO);
//
//        int userlist = userService.register(userDTO);
//        return new ResponseEntity<>(userlist, HttpStatus.OK);
//    }
//    @RequestMapping(value = "/join", method = RequestMethod.POST)
//    public String add(@RequestBody User user) throws Exception {
//        userService.add(user);
//        return "redirect:/myinfo";
//    }

    @RequestMapping("/member/myinfo")
    public void registerPost(MemberDTO memberDTO) {
        log.info("register...........");
        memberService.register(memberDTO);
//    attributes.addAttribute("username",userDTO.getUsername());
//    attributes.addAttribute("userid",userDTO.getUserid());
    }
}
