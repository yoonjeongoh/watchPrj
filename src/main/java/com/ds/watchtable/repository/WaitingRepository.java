package com.ds.watchtable.repository;

import com.ds.watchtable.dto.StoreDTO;
import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.entity.Waiting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WaitingRepository extends JpaRepository<Waiting, Long > {
    @Query("select w from Waiting w where w.store =:store")
    Page<Waiting> getWaitingByStore(Pageable pageable, Store store);


}
