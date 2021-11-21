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
    List<ReviewDTO> getListOfReview(Long storeNum);
    //리뷰수정
    void modify(ReviewDTO reviewDTO);
    //리뷰 삭제
    void remove(Long reviewNum);

    default Review dtoToEntity(ReviewDTO reviewDTO){
        Review review = Review.builder()
                .member(Member.builder()
                        .memberNum(reviewDTO.getMemberNum())
                        .memberId(reviewDTO.getMemberId())
                        .memberName(reviewDTO.getMemberName())
                        .memberNickname(reviewDTO.getMemberNickname())
                        .build())
                .store(Store.builder()
                        .storeNum(reviewDTO.getStoreNum())
                        .build())
                .reviewNum(reviewDTO.getReviewNum())
                .text(reviewDTO.getText())
                .build();
        return review;
    }

    default ReviewDTO entityToDTO(Review review) {
        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewNum(review.getReviewNum())
                .memberNum(review.getMember().getMemberNum())
                .memberId(review.getMember().getMemberId())
                .memberName(review.getMember().getMemberName())
                .memberNickname(review.getMember().getMemberNickname())
                .storeNum(review.getStore().getStoreNum())
                .text(review.getText())
                .regDate(review.getRegDate())
                .modDate(review.getModDate())
                .build();
        return reviewDTO;
    }

}
