package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table
public class Setting extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long posNum;

    private Long tableTwo;
    private Long tableFour;
    private Long tableSix;

/*    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Store store;*/
}
