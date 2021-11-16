package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "posorder")
public class PosOrder extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNum;

    private String order1;
    private String order2;
    private String order3;
    private String order4;

    private String orderNum1;
    private String orderNum2;
    private String orderNum3;
    private String orderNum4;

    private String drink1;
    private String drink2;

    private String drinkNum1;
    private String drinkNum2;




}
