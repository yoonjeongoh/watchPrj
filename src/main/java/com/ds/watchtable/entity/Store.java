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
    private Long storeNum;

    private String storeName;
    private String storeAds;
    private String storeTel;
    private String storeText;
    private String storeOpen;
    private String storeClose;


    private String bsNum;

    @JoinColumn(name = "memberNum")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Member member;

}
