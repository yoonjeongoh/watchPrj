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
public class PosTableDTO {
    private Long memberNum;

    private String memberName;
    private String memberNickname;
    private String memberId;
    private String memberPw;
    private String memberEmail;
    private String memberMobile;
    private LocalDateTime regDate;
    private LocalDateTime modDate;


    private Long storeNum;

    private String storeName;
    private String storeAds;
    private String storeTel;
    private String storeText;
    private String storeOpen;
    private String storeClose;
    private String bsNum;


    private Long posTableNum;

    private Long orderCount = 0l;
    private Long table1 = 0l;
    private Long table2 = 0l;
    private Long table3 = 0l;
    private Long table4 = 0l;
    private Long table5 = 0l;
    private Long table6 = 0l;
    private Long table7 = 0l;
    private Long table8 = 0l;
    private Long table9 = 0l;
}