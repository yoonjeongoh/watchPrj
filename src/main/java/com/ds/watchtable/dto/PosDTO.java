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
public class PosDTO {
    private Long posNum;


    private String menu1;
    private String menu2;
    private String menu3;
    private String menu4;

    private String drink1;
    private String drink2;

    private int table2;
    private int table4;
    private int table6;

    private Long storeNum;

}
