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
@RequestMapping
public class ReviewController {

    @Autowired
    final private ReviewService reviewService;

    //리뷰등록
    @RequestMapping("/addReview")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDTO reviewDTO) {
        log.info("--------------addReview1111---------------");
        log.info("reviewDTO: " + reviewDTO);
        Long reviewNum = reviewService.registerReview(reviewDTO);
        log.info("--------------addReview222---------------");
        return new ResponseEntity<>(reviewNum, HttpStatus.OK);
    }

    //스토어별 리뷰 리스트
    @RequestMapping("/addReview/list")
    public ResponseEntity<List<ReviewDTO>> reviewlist(@PathVariable("storeNum") Long storeNum) {
        log.info(">>>>>>>>>>Review11111<<<<<<<<<<<<<");
        List<ReviewDTO> reviewDTOList = reviewService.getListOfReview(storeNum);
        log.info(">>>>>>>>>>Review22222<<<<<<<<<<<<<");
        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }


    /*
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
*/
//    제이쿼리를 이용한 db저장
/*    @PostMapping("/watchtable/detail")
    public ResponseEntity<Long> addReview(ReviewDTO reviewDTO){
        Long reviewnum = reviewService.registerReview(reviewDTO);
        return new ResponseEntity<>( reviewnum, HttpStatus.OK);
    }*/

}

