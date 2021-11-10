package com.ds.watchtable.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {
    private Long memberNum;

    private String memberName;
    private String memberNickname;
    private String memberId;
    private String memberPw;
    private String memberEmail;
    private String memberMobile;
    private String type="MANAGER";


    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private int storeNum;

    private String storeName;
    private String storeAds;
    private String storeTel;
    private String storeText;
    private String storeOpen;
    private String storeClose;

    private String bsNum;
    @Builder.Default
    private List<StoreImageDTO> storeImageDTOList = new ArrayList<>();
    @Builder.Default
    private List<MenuImageDTO> menuImageDTOList = new ArrayList<>();

}
