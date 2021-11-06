package com.ds.watchtable.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor //매개변수가 없는 생성자(기본생성자)

public class ReviewDTO {
    private Long reviewnum;

//    private Long mno; //이게 있어야해..?
    private Long userid;
    private String username;
    private String usernick; //네임과 닉넴중에 하나만있어야하지 않나
    private String grade;
    private String text;
    private LocalDateTime regDate, modDate;
}
