package com.ds.watchtable.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.thymeleaf.spring5.processor.SpringObjectTagProcessor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreOrderDTO {
    private Long storeOrderNum;

    private String storeOrderList;

    private Long storeTableNum;
    private Long storeNum;
    private Long menuItemNum;

    private LocalDateTime regDate;
    private LocalDateTime modDate;


}
