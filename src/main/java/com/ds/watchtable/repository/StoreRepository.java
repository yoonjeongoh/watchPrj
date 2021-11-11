package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository <Store, Long> {
    Page<Object[]> getListPage(Pageable pageable);


}

