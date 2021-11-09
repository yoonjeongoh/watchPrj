package com.ds.watchtable.service;

import com.ds.watchtable.dto.ReviewDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Review;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    @Override
    public Long registerReview(ReviewDTO reviewDTO) {
        Review review = dtoToEntity(reviewDTO);
        reviewRepository.save(review);
        return review.getReviewnum();
    }

//    @Override
//    public List<ReviewDTO> getListOfStore(int storeNum) {
//        Store store = Store.builder().storeNum(storeNum).build();
//        List<Review> result = reviewRepository.findByStore(store);
//        return result.stream().map(review -> entityToDTO(review)).collect(Collectors.toList());
//    }



}
