package com.ds.watchtable.controller;

import com.ds.watchtable.dto.ReviewDTO;
import com.ds.watchtable.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    final private ReviewService reviewService;

    @GetMapping("/{storeNum}/all")
    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("storeNum") Long storeNum) {
        List<ReviewDTO> reviewDTOList = reviewService.getListOfStore(storeNum);
        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }

    @PostMapping("/{storeNum}")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDTO storeReviewDTO) {
        Long reviewNum = reviewService.registerReview(storeReviewDTO);
        return new ResponseEntity<>( reviewNum, HttpStatus.OK );
    }

    @PutMapping("/{storeNum}/{reviewnum}")
    public ResponseEntity<Long> modifyReview(@PathVariable Long reviewnum,
                                             @RequestBody ReviewDTO storeReviewDTO){
        log.info("---------------modify MovieReview--------------" + reviewnum);
        log.info("reviewDTO: " + storeReviewDTO);
        reviewService.modify(storeReviewDTO);

        return new ResponseEntity<>( reviewnum, HttpStatus.OK);
    }

    @DeleteMapping("/{storeNum}/{reviewnum}")
    public ResponseEntity<Long> removeReview( @PathVariable Long reviewnum){
        log.info("---------------modify removeReview--------------");
        log.info("reviewnum: " + reviewnum);
        reviewService.remove(reviewnum);
        return new ResponseEntity<>( reviewnum, HttpStatus.OK);
    }
//    제이쿼리를 이용한 db저장
/*    @PostMapping("/watchtable/detail")
    public ResponseEntity<Long> addReview(ReviewDTO reviewDTO){
        Long reviewnum = reviewService.registerReview(reviewDTO);
        return new ResponseEntity<>( reviewnum, HttpStatus.OK);
    }*/

}

