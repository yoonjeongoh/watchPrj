package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.MenuImage;
import com.ds.watchtable.entity.Store;
import com.ds.watchtable.entity.StoreImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface StoreRepository extends JpaRepository <Store, Long> {
//orm - entity이름으로

    //admin/storelist
    @Query("select s, si, mi " +
            "from Store s left outer join StoreImage si on si.store = s " +
            "left outer join MenuImage mi on mi.store = s ")
    Page<Object[]> getListPage(Pageable pageable);

    //admin/storeread
   @Query("select distinct s, si, mi " +
            "from Store s left outer join StoreImage si on si.store = s " +
            "left outer join MenuImage mi on mi.store = si.store " +
            "where s.storeNum =:storeNum ")
    Object[] getStoreDetail(Long storeNum);

   @Query("select s from Store s where s.member =:member ")
    Store findByMember(Member member);
}

