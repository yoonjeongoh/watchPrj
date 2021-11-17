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
public class OrderDTO {
    private Long orderNum;

    private String orderList;

    private Long storeTableNum;
    private Long storeNum;
    private Long menuItemNum;

    private LocalDateTime regDate;
    private LocalDateTime modDate;


}
