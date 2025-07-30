package com.mjc813.swimpool_app.swimpool.service;

import com.mjc813.swimpool_app.swimpool.dto.SwimpoolDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SwimpoolService {
    @Autowired
    private ISwimpoolMybatis mybatisMapper;

    public SwimpoolDto insert(SwimpoolDto dto){
        // log.debug(dto.getAddr()); 해당식으로 로그를 풀어낼수도 있음
        this.mybatisMapper.insert(dto);
        return dto;
    }


    public List<SwimpoolDto> findAll(){
        List<SwimpoolDto> all = this.mybatisMapper.findAll();
        return all;
    }

    public SwimpoolDto getOne(Integer id){
        SwimpoolDto one = this.mybatisMapper.getOne(id);
        return one;
    }

    public SwimpoolDto update(SwimpoolDto dto){
        this.mybatisMapper.update(dto);
        return dto; // 또는 update후 DB에서 새로 조회해서 반환해도 됨
    }
    public void delete(Integer id){
        this.mybatisMapper.delete(id);
    }

    public Long countBySearch(String search) {
        return mybatisMapper.countBySearch(search);
    }
    public List<SwimpoolDto> findBySearch(String search, int size, int offset) {
        return mybatisMapper.findBySearch(search, size, offset);
    }
}
