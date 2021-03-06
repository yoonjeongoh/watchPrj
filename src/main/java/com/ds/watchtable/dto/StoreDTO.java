package com.ds.watchtable.dto;

import com.ds.watchtable.entity.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime regDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime modDate;

    private Long posTableNum;

    private Long orderCount;

    private Long table1;
    private Long table2;
    private Long table3;
    private Long table4;
    private Long table5;
    private Long table6;
    private Long table7;
    private Long table8;
    private Long table9;

    private Long storeNum;

    private String storeName;
    private String storeAds;
    private String storeTel;
    private String storeText;
    private String storeOpen;
    private String storeClose;

    private String bsNum;
    private PosTableDTO posTableDTO = new PosTableDTO();
    private List<StoreImageDTO> storeImageDTOList = new ArrayList<>();
    private List<MenuImageDTO> menuImageDTOList = new ArrayList<>();

    private Long likesNum;
}
