package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;

    private String memberId;

    private String memberName;
    private String memberNickname;
    private String memberPw;
    private String memberEmail;
    private String memberMobile;

    private boolean fromSocial;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void addMemberRole(MemberRole memberRole) {
        roleSet.add(memberRole);
    }

    public void newSocial(String newSocial){
        this.memberId = newSocial;
        this.memberName = newSocial;
        this.memberNickname = newSocial;
        this.memberMobile = newSocial;



    }

}
