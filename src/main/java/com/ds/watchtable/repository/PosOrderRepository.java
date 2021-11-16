package com.ds.watchtable.repository;

import com.ds.watchtable.entity.PosOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PosOrderRepository extends JpaRepository<PosOrder, Long> {
    @Query("select s, si, mi " +
            "from Store s left outer join StoreImage si on si.store = s " +
            "left outer join MenuImage mi on mi.store = s " +
            "where s.storeNum =:storeNum ")
    List<Object[]> getPosOrder(Long storeNum);
}
