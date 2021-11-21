package com.ds.watchtable.dto;

import com.ds.watchtable.entity.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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


    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private Long posTableNum;

    private Long orderCount;

    private Long table1 =0l;
    private Long table2=0l;
    private Long table3=0l;
    private Long table4=0l;
    private Long table5=0l;
    private Long table6=0l;
    private Long table7=0l;
    private Long table8=0l;
    private Long table9=0l;

    private Long storeNum;

    private String storeName;
    private String storeAds;
    private String storeTel;
    private String storeText;
    private String storeOpen;
    private String storeClose;

    private String bsNum;

    private List<StoreImageDTO> storeImageDTOList = new ArrayList<>();
    private List<MenuImageDTO> menuImageDTOList = new ArrayList<>();
}
