package com.ds.watchtable.repository;

import com.ds.watchtable.entity.MenuImage;
import com.ds.watchtable.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuImageRepository extends JpaRepository<MenuImage, Long> {
    @Query("select mi from MenuImage mi where mi.store =:store")
    List<MenuImage> getMenuImageListByStoreNum(Store store);

}
