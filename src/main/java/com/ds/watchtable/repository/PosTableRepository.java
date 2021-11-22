package com.ds.watchtable.repository;

import com.ds.watchtable.entity.PosTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PosTableRepository extends JpaRepository<PosTable, Long> {
    @Query("select p from PosTable p where p.posTableNum =:posTableNum")
    Object[] getPosTable(Long posTableNum);

}
