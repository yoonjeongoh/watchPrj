package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table
public class StoreOrder extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeOrderNum;

    private Long StoreNum;
    private Long TableNum;
    private Boolean checkOrder;

}
