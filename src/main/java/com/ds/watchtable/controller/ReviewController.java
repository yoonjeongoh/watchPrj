package com.ds.watchtable.controller;

import com.ds.watchtable.dto.ReviewDTO;
import com.ds.watchtable.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    @Autowired
    final private ReviewService reviewService;

    @PostMapping("/watchtable/detailed")
    public ResponseEntity<Long> addReview(@ModelAttribute ReviewDTO reviewDTO){
        log.info("--------------add MovieReview---------------");
        log.info("reviewDTO: " + reviewDTO);
        Long reviewnum = reviewService.registerReview(reviewDTO);
        return new ResponseEntity<>( reviewnum, HttpStatus.OK);

    }


}
