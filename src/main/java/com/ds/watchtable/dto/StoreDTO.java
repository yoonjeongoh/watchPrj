package com.ds.watchtable.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {
    private int memberNum;

    private String memberName;
    private String memberNickname;
    private String memberId;
    private String memberPw;
    private String memberEmail;
    private String memberMobile;
    private String type;


    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private int storeNum;

    private String storeName;
    private String storeMenu;
    private String storeAds;
    private String storeTel;
    private String storeText;
    private String storeBh;

    private String bsNum;
    private String bsImg;
}
