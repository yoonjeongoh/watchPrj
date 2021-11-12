package com.ds.watchtable.dto;

import com.ds.watchtable.entity.MemberRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long memberNum;

    private String memberName;
    private String memberId;
    private String memberPw;
    private String memberEmail;
    private String memberMobile;
    private String memberNickname;

    private boolean fromSocial;

    private Set<MemberRole> roleSet;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
