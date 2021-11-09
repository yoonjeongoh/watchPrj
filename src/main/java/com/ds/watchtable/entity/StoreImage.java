package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "store")
public class StoreImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inum;

    private String uuid;
    private String imgName;
    private String path;
    private String imgType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;
}
