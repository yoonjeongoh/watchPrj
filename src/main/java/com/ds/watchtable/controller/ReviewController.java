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
public class ReviewController {

    @Autowired
    final private ReviewService reviewService;

//    제이쿼리를 이용한 db저장
/*    @PostMapping("/watchtable/detailed")
    public ResponseEntity<Long> addReview(ReviewDTO reviewDTO){
        Long reviewnum = reviewService.registerReview(reviewDTO);
        return new ResponseEntity<>( reviewnum, HttpStatus.OK);
    }*/

/*
    @GetMapping("/all")
    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("mno") Long mno){
        log.info("--------------list---------------");
        log.info("MNO: " + mno);
        List<ReviewDTO> reviewDTOList = reviewService.getListOfMovie(mno);
        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }
    */

//ajax를 이용한 데이터 저장
    @PostMapping("/detailed")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDTO reviewDTO){
        Long reviewnum = reviewService.registerReview(reviewDTO);
        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }

//    리스트 나오게 하기..
//    @GetMapping("/detailed/all")
//    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("storeNum") int storeNum){
//        List<ReviewDTO> reviewDTOList = reviewService.getListOfStore(storeNum);
//        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
//    }



}

