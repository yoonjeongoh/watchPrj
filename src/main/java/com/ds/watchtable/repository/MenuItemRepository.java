package com.ds.watchtable.repository;

import com.ds.watchtable.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long > {
}
