package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Waiting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitingRepository extends JpaRepository<Waiting, Long > {


}
