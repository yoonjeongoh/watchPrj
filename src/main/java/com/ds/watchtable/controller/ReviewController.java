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
    @RequestMapping("/addReview/{storeNum}")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDTO reviewDTO) {
        log.info("--------------addReview1111---------------");
        log.info("reviewDTO1111: " + reviewDTO);
        Long reviewNum = reviewService.registerReview(reviewDTO);
        log.info("reviewDTO2222: " + reviewDTO);
        log.info("--------------addReview222---------------"+reviewNum);
        return new ResponseEntity<>(reviewNum, HttpStatus.OK);
    }

    //스토어별 리뷰 리스트
    @GetMapping("/addReview/{storeNum}/list")
    public ResponseEntity<List<ReviewDTO>> reviewlist(@PathVariable("storeNum") Long storeNum) {
        log.info(">>>>>>>>>>Review11111<<<<<<<<<<<<<");
        List<ReviewDTO> reviewDTOList = reviewService.getListOfReview(storeNum);
        log.info(">>>>>>>>>>Review22222<<<<<<<<<<<<<"+reviewDTOList);
        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }

    //리뷰수정
    @PutMapping("/addReview/{storeNum}/{reviewNum}")
    public ResponseEntity<Long> modifyReview(@PathVariable Long reviewNum,
                                             @RequestBody ReviewDTO reviewDTO){
        log.info("---------------modify MovieReview--------------" + reviewNum);
        log.info("reviewDTO: " + reviewDTO);
        reviewService.modify(reviewDTO);

        return new ResponseEntity<>( reviewNum, HttpStatus.OK);
    }

    //리뷰 삭제
    @DeleteMapping("/addReview/{storeNum}/{reviewNum}")
    public ResponseEntity<Long> removeReview( @PathVariable Long reviewNum){
        log.info("---------------delete removeReview--------------");
        log.info("reviewNum: " + reviewNum);
        reviewService.remove(reviewNum);
        return new ResponseEntity<>( reviewNum, HttpStatus.OK);
    }

}

