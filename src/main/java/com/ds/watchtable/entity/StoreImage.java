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

    private String bsUuid;
    private String bsImgName;
    private String bsPath;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;
}
