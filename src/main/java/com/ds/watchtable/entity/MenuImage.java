package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "store")
public class MenuImage extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int minum;

    private String menuUuid;
    private String menuImgName;
    private String menuPath;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;
}
