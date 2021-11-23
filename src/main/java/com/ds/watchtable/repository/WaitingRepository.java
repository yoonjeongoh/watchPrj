package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Waiting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaitingRepository extends JpaRepository<Waiting, Long > {

}
