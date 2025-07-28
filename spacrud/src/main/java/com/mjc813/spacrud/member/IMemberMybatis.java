package com.mjc813.spacrud.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMemberMybatis {
    public void addMember(MemberDto obj);
    public List<MemberDto> findAll();
    public MemberDto findById(Long id);
    public void update(MemberDto dto);
    public void deleteById(Long id);
}
