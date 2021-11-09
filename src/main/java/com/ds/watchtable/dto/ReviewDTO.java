package com.ds.watchtable.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor //매개변수가 없는 생성자(기본생성자)
public class ReviewDTO {
    private Long reviewnum;

//    private int memberNum;
//    private String memberId;
//    private String memberName;
//    private String memberNickname;

    private String text;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
//    private int reviewCount;
}
