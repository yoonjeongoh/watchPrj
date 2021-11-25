package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Review;
import com.ds.watchtable.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
  @EntityGraph(attributePaths = {"member"}, type = EntityGraph.
          EntityGraphType.FETCH)
  List<Review> findByStore(Store store);

  @Query("select r from Review r where r.member =:member")
  Page<Review> getReviewByUser(Pageable pageable, Member member);

}
