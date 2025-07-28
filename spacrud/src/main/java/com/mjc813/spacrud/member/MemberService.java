package com.mjc813.spacrud.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private IMemberMybatis mybatisMapper;

    public void addMember(MemberDto member) {
        this.mybatisMapper.addMember(member);
    }

    public List<MemberDto> findAll() {
        List<MemberDto> all = this.mybatisMapper.findAll();
        return all;
    }

    public MemberDto findById(Long num) {
        MemberDto byId = this.mybatisMapper.findById(num);
        return byId;
    }

    public void update(MemberDto dto) {
        this.mybatisMapper.update(dto);
    }

    public void deleteById(Long id) {
        this.mybatisMapper.deleteById(id);
    }
}
