package com.ds.watchtable.controller;

import com.ds.watchtable.dto.ReviewDTO;
import com.ds.watchtable.security.util.JWTUtil;
import com.ds.watchtable.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping({"/watchtable","/member","/pos","/review","/admin","manager"})
public class WatchtableController {
    @GetMapping({"/detail","/manageinfocorrect","/myinfo","/managemyinfo",
            "/myreview","/storereview","/kitchen" ,"/loginmng"})

    public void list(){
    }

}