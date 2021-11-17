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
public class MenuItemDTO {
    private Long menuItemNum;

    private String menu;
    private String side;
    private String drink;

    private String storeNum;
    private String storeTableNum;

    private LocalDateTime regDate;
    private LocalDateTime modDate;


}
