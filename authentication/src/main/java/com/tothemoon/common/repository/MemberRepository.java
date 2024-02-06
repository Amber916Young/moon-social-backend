package com.tothemoon.common.repository;

import com.tothemoon.common.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String email);

    boolean existsByEmailAndIdIsNot(String email, long id);

    Optional<Member> findByEmail(String email);

    Optional<Member> findByResetKey(String resetKey);

}
