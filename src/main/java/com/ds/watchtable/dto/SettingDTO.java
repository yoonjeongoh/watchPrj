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

    private Long tableTwo;
    private Long tableFour;
    private Long tableSix;

    private Long storeNum;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
