package com.example.post.repository;


import com.example.post.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Query("select m from Member as m where m.email = :email")
    Optional<Member> findByEmail(@Param("email")String email);
}
