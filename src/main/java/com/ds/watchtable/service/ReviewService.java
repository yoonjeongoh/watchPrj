package com.ds.watchtable.service;

import com.ds.watchtable.dto.ReviewDTO;
import com.ds.watchtable.entity.Review;

public interface ReviewService {
    Long registerReview(ReviewDTO reviewDTO);

    default Review dtoToEntity(ReviewDTO reviewDTO){
        Review review = Review.builder()
                .reviewnum(reviewDTO.getReviewnum())
                .text(reviewDTO.getText())
                .build();
        return review;
    }

    default ReviewDTO entityToDTO(Review review) {
        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewnum(review.getReviewnum())
                .text(review.getText())
                .regDate(review.getRegDate())
                .modDate(review.getModDate())
                .build();
        return reviewDTO;
    }

}
