package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Pos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;

public interface PosRepository extends JpaRepository<Pos, Long>
        , QuerydslPredicateExecutor<Pos> {

}
