package com.ds.watchtable.repository;

import com.ds.watchtable.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from Member m where m.fromSocial =:social and m.memberId=:Id")
    Optional<Member> findByMemberId(String Id, boolean social);

    @Query("select m from Member m where m.memberName =:memberName")
    Member findByMemberName(String memberName);
}
