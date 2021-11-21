package com.ds.watchtable.repository;

import com.ds.watchtable.entity.PosTable;
import com.ds.watchtable.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosTableRepository extends JpaRepository<PosTable, Long> {
}
