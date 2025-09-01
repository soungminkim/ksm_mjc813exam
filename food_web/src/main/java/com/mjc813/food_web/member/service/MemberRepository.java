package com.mjc813.food_web.member.service;

import com.mjc813.food_web.member.dto.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    List<MemberEntity> findByUsernameEquals(String username);
    List<MemberEntity> findByUsernameEqualsAndNickNameEquals(String username, String nickName);
}
