package com.ds.watchtable.security.dto;

import com.ds.watchtable.entity.Member;
import com.ds.watchtable.entity.PosTable;
import com.ds.watchtable.entity.Store;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Log4j2
@Getter
@Setter
@ToString
public class ClubAuthStoreDTO extends User implements OAuth2User {
    private String memberId;
    private String password;
    private String name;
    private boolean fromSocial;
    private Member member;
    private Store store;
    private PosTable posTable;

    private String memberid;
    private String memberName;
    private String memberNickname;
    private String memberMobile;

    private Map<String, Object> attr;


    public ClubAuthStoreDTO(String username, String password, boolean fromSocial,
                             Collection<? extends GrantedAuthority> authorities,
                             Map<String, Object> attr) {
        this(username, password, fromSocial, authorities);
        this.attr = attr;
    }

    public ClubAuthStoreDTO(String username, String password,
                             boolean fromSocial,
                             Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.memberId = username;
        this.password = password;
        this.fromSocial = fromSocial;

    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attr;
    }

    public void setMember(String memberid,String memberName,String memberNickname,String memberMobile) {
        this.memberid = memberid;
        this.memberName = memberName;
        this.memberNickname = memberNickname;
        this.memberMobile = memberMobile;
    }
}
