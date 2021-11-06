package com.ds.watchtable.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping({"/watchtable","/join","/member","/pos","/review","/admin"})
public class WatchtableController {
    @GetMapping({"/admin","/approve","/approvefiles","/checkpw","/detailed","/join","/joinselect",
            "/login","/manage","/manageinfocorrect","/managemyinfo","/managerjoin","/myinfo",
    "/myinfocorrect","/myreview","/storereview","/wating1","/wating2","/wating3", "/managerjoin2",
            "/kitchen" , "/postable", "/posorder","/waiting1","/waiting2","/waiting3","/loginmng",
    "/possetting"})

    public void list(){
    }
}