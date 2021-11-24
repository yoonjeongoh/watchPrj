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
public class PosTableDTO {
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
}