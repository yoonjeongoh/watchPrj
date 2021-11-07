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
public class Store extends com.ds.watchtable.entity.BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeNum;

    private String storeName;
    private String storeMenu;
    private String storeAds;
    private String storeTel;
    private String storeText;
    private String storeBh;

    private String bsNum;
    private String bsImg;

    @ManyToOne(cascade = CascadeType.ALL)
    Member member;

}
