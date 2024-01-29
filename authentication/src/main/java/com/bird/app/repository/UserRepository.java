package com.bird.app.repository;

import com.bird.common.entity.Member;
import com.bird.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String email);

    boolean existsByEmailAndIdIsNot(String email, long id);

    Optional<Member> findByEmail(String email);

    Optional<Member> findByResetKey(String resetKey);

    List<Member> findCompanyUserByCompanyIdAndRole(Long companyId, Role role);
}
