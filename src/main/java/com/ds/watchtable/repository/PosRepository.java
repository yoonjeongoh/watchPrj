package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Pos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PosRepository extends JpaRepository<Pos, Long> {
//    List<Object[]> getPosAll(Long posNum);
}
