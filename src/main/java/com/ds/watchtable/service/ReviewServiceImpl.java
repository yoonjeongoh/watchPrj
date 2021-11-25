package com.ds.watchtable.service;

import com.ds.watchtable.dto.PageRequestDTO;
import com.ds.watchtable.dto.PageResultDTO;
import com.ds.watchtable.dto.ReviewDTO;
import com.ds.watchtable.dto.WaitingDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Review;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.entity.Waiting;
import com.ds.watchtable.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    //DB저장
    @Override
    public Long registerReview(ReviewDTO reviewDTO) {
        Review review = dtoToEntity(reviewDTO);
        reviewRepository.save(review);
        log.info("saveReview-----"+review);
        return review.getReviewNum();
    }

    //리뷰리스트
    @Override
    public List<ReviewDTO> getListOfReview(Long storeNum) {
        log.info(">>>>>>>>>>>>ReviewImpl1111111<<<<<<<<<<<<<<<<");
        Store store = Store.builder().storeNum(storeNum).build();
        log.info(">>>>>>>>>>>>ReviewImpl2222222<<<<<<<<<<<<<<<<");
        List<Review> result = reviewRepository.findByStore(store);
        log.info(">>>>>>>>>>>>ReviewImp33333333<<<<<<<<<<<<<<<<");
        return result.stream().map(review -> entityToDTO(review)).collect(Collectors.toList());
    }

    //리뷰수정
    @Override
    public void modify(ReviewDTO reviewDTO) {
        Optional<Review> result =
                reviewRepository.findById(reviewDTO.getReviewNum());
        if(result.isPresent()) {
            Review review = result.get();
            log.info(">>>>>>>>review4444<<<<<<<"+result);
            review.changeText(reviewDTO.getText());
            reviewRepository.save(review);
           }
    }

    //리뷰삭제
    @Override
    public void remove(Long reviewNum) {
        reviewRepository.deleteById(reviewNum);
    }

    //유저 리뷰 리스트
    @Override
    public PageResultDTO<ReviewDTO, Review> getUserReview(PageRequestDTO requestDTO, Member member) {
        Pageable pageable = requestDTO.getPageable(Sort.by("reviewNum").descending());
        log.info("----------review1111111-----------"+pageable);
        Page<Review> result = reviewRepository.getReviewByUser(pageable, member);
        log.info("----------review2222222-----------"+result);
        Function<Review, ReviewDTO> fn = (entity -> entityToDTO(entity));
        log.info("----------review3333333-----------"+fn);
        return new PageResultDTO<>(result, fn);
    }


}
