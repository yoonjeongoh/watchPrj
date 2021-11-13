package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static com.ds.watchtable.entity.QStore.store;

public interface StoreRepository extends JpaRepository <Store, Long> {
//orm - entity이름으로

    //리스트
    @Query("select s, si, mi " +
            "from Store s left outer join StoreImage si on si.store = s " +
            "left outer join MenuImage mi on mi.store = s ")
    Page<Object[]> getListPage(Pageable pageable);

    //상세보기
   @Query("select s, si, mi " +
            "from Store s left outer join StoreImage si on si.store = s " +
            "left outer join MenuImage mi on mi.store = s " +
            "where s.storeNum =:storeNum ")
    List<Object[]> getStoreDetail(Long storeNum);


}

