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

    private Long size;
    private Long tableNum;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
