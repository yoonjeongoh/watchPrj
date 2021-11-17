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
public class SettingDTO {
    private Long posNum;

    private int tableTwo;
    private int tableFour;
    private int tableSix;

//    private Long storeNum;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
