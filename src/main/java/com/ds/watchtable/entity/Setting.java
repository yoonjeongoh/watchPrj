package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "store")
@Table(name = "table")
public class Setting extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableNum;

    private String tableTwo;
    private String tableFour;
    private String tableSix;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Store store;
}
