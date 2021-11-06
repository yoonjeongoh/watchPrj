package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "member")
public class Member extends com.ds.watchtable.entity.BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNum;

    private String memberId;

    private String memberName;
    private String memberPw;
    private String memberEmail;
    private String memberMobile;
}
