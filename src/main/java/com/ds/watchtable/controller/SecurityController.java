package com.ds.watchtable.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class SecurityController {

    @GetMapping({"","/"})
    public String home(Model model){
        log.info("home controller");
        return "/index";
    }
    @GetMapping("/myinfo")
    public String dispUser(Model model){
        log.info("home controller");
        return "/member/myinfo";
    }
    @GetMapping("/manage")
    public String dispManager(Model model){
        log.info("home controller");
        return "/member/manage";
    }
    @GetMapping("/admin")
    public String dispAdmin(Model model){
        log.info("home controller");
        return "/admin/admin";
    }
}
