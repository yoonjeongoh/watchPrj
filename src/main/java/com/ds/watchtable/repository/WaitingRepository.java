package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Waiting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WaitingRepository extends JpaRepository<Waiting, Long > {
    @Query(value = "select w from Waiting w where w.storeNum =:1 ", nativeQuery = true)
    Page<Waiting> getWaitingByStore(Pageable pageable);

}
