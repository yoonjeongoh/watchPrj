package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "pos")
public class Pos extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Store store;
}
