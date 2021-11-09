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
public class MemberDTO {
    private Long memberNum;

    private String memberName;
    private String memberId;
    private String memberPw;
    private String memberEmail;
    private String memberMobile;
    private String memberNickname;
    private String type="USER";


    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
