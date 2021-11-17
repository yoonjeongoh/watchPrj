package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "store")
@Table(name = "storetable")
public class StoreTable extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeTableNum;

    private String tableTwo;
    private String tableFour;
    private String tableSix;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Store store;
}
