package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreRepositoryTest {
    @Autowired
    StoreRepository storeRepository;

    @Test
    public void insertStores() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Store store = Store.builder()
                    .storeNum((long) i++)
                    .storeName("store" + i)
                    .storeMenu("menu" + i)
                    .storeAds("adr" + i)
                    .storeTel("tel" + i)
                    .storeText("text" + i)
                    .storeOpen("12")
                    .storeClose("13")
                    .bsNum("num" + i)
                    .bsImg("img" + i)
                    .build();
            storeRepository.save(store);
        });
    }
}