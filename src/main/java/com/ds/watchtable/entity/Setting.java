package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "store")
@Table(name = "setting")
public class Setting extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long posNum;

    private int tableTwo;
    private int tableFour;
    private int tableSix;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Store store;
}
