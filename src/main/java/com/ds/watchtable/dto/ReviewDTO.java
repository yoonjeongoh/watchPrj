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

//    private Long storenum;
//    private String username;
//    private String usernick; //네임과 닉넴중에 하나만있어야하지 않나
//    private String grade;
    private String text;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
//    private int reviewCount;
}
