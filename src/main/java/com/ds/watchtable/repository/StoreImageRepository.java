package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Store;
import com.ds.watchtable.entity.StoreImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreImageRepository extends JpaRepository<StoreImage, Long> {
    @Query("select si from StoreImage si where si.store =:store")
    List<StoreImage> getStoreImageListByStoreNum(Store store);

}
