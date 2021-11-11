package com.ds.watchtable.controller;

import com.ds.watchtable.dto.MemberDTO;
import com.ds.watchtable.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @RequestMapping("/member/myinfo")
    public void registerPost(MemberDTO memberDTO) {
        log.info("register...........");
        memberService.register(memberDTO);
//    attributes.addAttribute("username",userDTO.getUsername());
//    attributes.addAttribute("userid",userDTO.getUserid());
    }

    @GetMapping("/login") //get-불러오기
    private void login() {

    }
}



//-----------예진이 삽질의 흔적-------------------------------------------
    //session으로부터 정보들고오는거 - principal
//    @GetMapping("/member/myinfocorrect") //이거미완성
//    private void getInfo(Model model, Principal principal) {
//
//        log.info("memberNum>>"+memberNum);
//        MemberDTO dto = memberService.get(memberNum);
//        model.addAttribute("memberDTO", dto );
//        log.info("dto>>"+dto);
//    }



//    @GetMapping("/member/myinfocorrect") //get-불러오기
//    private void getInfo(Long memberNum, Model model) {
//        log.info("memberNum>>"+memberNum);
//        MemberDTO dto = memberService.get(memberNum);
//        model.addAttribute("memberDTO", dto );
//        log.info("dto>>"+dto);
//    }

//
//    @GetMapping("/member/myinfocorrect", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<MemberDTO>> get(@PathVariable("memberNum") Long memberNum){
//        return new ResponseEntity<>( memberService.get(memberNum), HttpStatus.OK);
//    }


//    @RequestMapping(value = "/member/myinfocorrect/", method = RequestMethod.GET)
//    public @ResponseBody Member getInfo(@PathVariable("memberNum") Long memberNum){
//        return memberService.get(memberNum);
//    }





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


