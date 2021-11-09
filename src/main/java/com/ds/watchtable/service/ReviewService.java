package com.ds.watchtable.service;

import com.ds.watchtable.dto.ReviewDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Review;
import com.ds.watchtable.entity.Store;

import java.util.List;

public interface ReviewService {
    //리뷰 추가
    Long registerReview(ReviewDTO reviewDTO);
    //리뷰 리스트
//    List<ReviewDTO> getListOfStore(int storeNum);

    default Review dtoToEntity(ReviewDTO reviewDTO){
        Review review = Review.builder()
//                .member(Member.builder()
//                        .memberNum(reviewDTO.getMemberNum())
//                        .memberId(reviewDTO.getMemberId())
//                        .memberName(reviewDTO.getMemberName())
//                        .memberNickname(reviewDTO.getMemberNickname())
//                        .build())
                .reviewnum(reviewDTO.getReviewnum())
                .text(reviewDTO.getText())
                .build();
        return review;
    }

    default ReviewDTO entityToDTO(Review review) {
        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewnum(review.getReviewnum())
//                .memberNum(review.getMember().getMemberNum())
//                .memberId(review.getMember().getMemberId())
//                .memberName(review.getMember().getMemberName())
//                .memberNickname(review.getMember().getMemberNickname())
                .text(review.getText())
                .regDate(review.getRegDate())
                .modDate(review.getModDate())
                .build();
        return reviewDTO;
    }

}
