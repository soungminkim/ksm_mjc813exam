package com.mjc813.swimpool_app.swimpool.service;

import com.mjc813.swimpool_app.swimpool.dto.SwimpoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwimpoolService {
    @Autowired
    private ISwimpoolMybatis mybatisMapper;

    public SwimpoolDto insert(SwimpoolDto dto){
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

}
