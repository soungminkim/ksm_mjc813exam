package com.mjc813.food_web.member.service;

import com.mjc813.food_web.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface IMemberMybatis {
    public void insert(MemberDto obj);
    public List<MemberDto> findAll();
    public MemberDto findById(Long id);
    public MemberDto findByUsername(String username);
    public void update(MemberDto dto);
    public void deleteById(Long id);

    List<MemberDto> findByUsernameContainsAndNickNameContains(String username, String nickName, String role, Pageable pageable);
    Long countByUsernameContainsAndNickNameContains(String username, String nickName, String role);
    void changePasswd(MemberDto dto);
}
