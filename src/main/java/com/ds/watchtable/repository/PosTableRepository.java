package com.ds.watchtable.repository;

import com.ds.watchtable.entity.PosTable;
import com.ds.watchtable.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PosTableRepository extends JpaRepository<PosTable, Long> {
    @Query("select p from PosTable p where p.posTableNum =:posTableNum")
    Object[] getPosTable(Long posTableNum);

    @Query("select p from PosTable p where p.store =:store ")
    PosTable findByPosTableToStore(Store store);

}
