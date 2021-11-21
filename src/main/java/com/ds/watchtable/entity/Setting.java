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
    private Long tableNum;

    private String size;






    @JoinColumn(name = "storeNum")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Store store;

}
