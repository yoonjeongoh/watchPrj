package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "postable")
public class PosTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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



    @JoinColumn(name="storeNum")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Store store;
}
