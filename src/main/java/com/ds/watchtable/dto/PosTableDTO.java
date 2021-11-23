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
    private Long orderCount = 0l;
    private Long table1 = 0l;
    private Long table2 = 0l;
    private Long table3 = 0l;
    private Long table4 = 0l;
    private Long table5 = 0l;
    private Long table6 = 0l;
    private Long table7 = 0l;
    private Long table8 = 0l;
    private Long table9 = 0l;
    private Long storeNum;
}