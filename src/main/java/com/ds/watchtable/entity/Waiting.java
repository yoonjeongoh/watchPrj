package com.ds.watchtable.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"member", "store"})
@Table
public class Waiting extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long waitingNum;

    private String partyMember;

    @JoinColumn(name = "memberNum")
    @ManyToOne(fetch = FetchType.LAZY)
    Member member;

    @JoinColumn(name = "storeNum")
    @ManyToOne(fetch = FetchType.LAZY)
    Store store;

    public void changePartyMember(String partyMember){
        this.partyMember = partyMember;
    }


}
