package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "store")
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeNum;

    private String storeName;
    private String storeMenu;
    private String storeAds;
    private String storeTel;
    private String storeText;
    private String storeOpen;
    private String storeClose;


    private String bsNum;
    private String bsImg;

    @JoinColumn(name = "memberNum")
    @ManyToOne(cascade = CascadeType.ALL)
    Member member;

}
