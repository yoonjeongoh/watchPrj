package com.ds.watchtable.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PosOrderDTO {
    private Long orderNum;

    private String orderList;


    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
