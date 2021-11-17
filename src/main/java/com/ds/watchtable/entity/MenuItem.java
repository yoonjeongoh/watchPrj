package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Table(name="menuItem")
public class MenuItem extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuItemNum;

    private String menu;
    private String side;
    private String drink;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Store store;

}
