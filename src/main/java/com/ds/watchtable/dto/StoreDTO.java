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
    private String type="MANAGER";


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
    private Set<MemberRole> roleSet;

    private List<StoreImageDTO> storeImageDTOList = new ArrayList<>();
    private List<MenuImageDTO> menuImageDTOList = new ArrayList<>();
}
