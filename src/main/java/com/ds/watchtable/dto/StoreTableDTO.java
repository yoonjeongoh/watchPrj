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
public class StoreTableDTO {
    private Long storeTableNum;

    private String tableTwo;
    private String tableFour;
    private String tableSix;

    private String storeNum;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
