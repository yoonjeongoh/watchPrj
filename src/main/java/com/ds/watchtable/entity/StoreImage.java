package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "store")
public class StoreImage extends com.ds.watchtable.entity.BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storenum;

    private String menuImg;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;


}
