package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "member")
public class ProfileImage extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pinum;

    private String profileUuid;
    private String profileImgName;
    private String profilePath;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
