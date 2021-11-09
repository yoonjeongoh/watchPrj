package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.repository.MemberRepository;
import com.ds.watchtable.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private final MemberService memberService;

    @RequestMapping("/member/myinfo")
    public void registerPost(MemberDTO memberDTO) {
        log.info("register...........");
        memberService.register(memberDTO);
//    attributes.addAttribute("username",userDTO.getUsername());
//    attributes.addAttribute("userid",userDTO.getUserid());
    }

//    @GetMapping("/member/myinfocorrect") //get-불러오기
//    private void getInfo(Long memberNum, Model model) {
//        MemberDTO memberDTO = memberService.get(memberNum);
//        model.addAttribute("memberDTO0", memberDTO);
//    }
}



//  ----삽질의 흔적-------------------------------------------

//    //db넘기는거 확인-ok
//    @GetMapping("/member/myinfocorrect")
//    public String getInfo(Model model){
//        model.addAttribute("data","tlqkf");
//        return "/member/myinfocorrect";
//    }


    //    @GetMapping("/member/myinfocorrect")
//    public void getInfo(int memberNum, @ModelAttribute("dto") Model model) {
//        MemberDTO memberDTO = memberService.getInfo(memberNum);
//        model.addAttribute("dto", memberDTO);
//    }

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


