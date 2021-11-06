package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
