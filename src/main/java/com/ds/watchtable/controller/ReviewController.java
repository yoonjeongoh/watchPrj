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
        Long reviewNum = reviewService.registerReview(reviewDTO);
        return new ResponseEntity<>(reviewNum, HttpStatus.OK);
    }

    //스토어별 리뷰 리스트
    @GetMapping("/addReview/{storeNum}/list")
    public ResponseEntity<List<ReviewDTO>> reviewlist(@PathVariable("storeNum") Long storeNum) {
        List<ReviewDTO> reviewDTOList = reviewService.getListOfReview(storeNum);
        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }

    //리뷰수정
    @PutMapping("/addReview/{storeNum}/{reviewNum}")
    public ResponseEntity<Long> modifyReview(@PathVariable Long reviewNum,
                                             @RequestBody ReviewDTO reviewDTO){
        reviewService.modify(reviewDTO);
        return new ResponseEntity<>( reviewNum, HttpStatus.OK);
    }

    //리뷰 삭제
    @DeleteMapping("/addReview/{storeNum}/{reviewNum}")
    public ResponseEntity<Long> removeReview( @PathVariable Long reviewNum){
        reviewService.remove(reviewNum);
        return new ResponseEntity<>( reviewNum, HttpStatus.OK);
    }

}

