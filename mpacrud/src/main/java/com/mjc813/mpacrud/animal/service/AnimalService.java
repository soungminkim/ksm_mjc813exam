package com.mjc813.mpacrud.animal.service;

import com.mjc813.mpacrud.animal.dto.AnimalDto;
import com.mjc813.mpacrud.animal.dto.SearchRequestDto;
import com.mjc813.mpacrud.animal.mybatis.AnimalMybatisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 클래스를 스프링프레임워크에서 자동 생성 가능한 서비스형 클래스로 만듬,  @Autowired 애노테이션 으로 객체 생성 가능
public class AnimalService {
    @Autowired  // 스프링프레임워크가 객체를 인스턴스(생성) 해준다.
    private AnimalMybatisMapper animalMybatisMapper;

    public void insert(AnimalDto dto) {
        this.animalMybatisMapper.insertAnimal(dto);
    }

    public List<AnimalDto> findAll() {
        List<AnimalDto> all = this.animalMybatisMapper.findAll();
        return all;
    }

    public AnimalDto findById(Long id) {
        return this.animalMybatisMapper.findById(id);
    }

    public void update(AnimalDto dto) {
        this.animalMybatisMapper.update(dto);
    }

    public void delete(Long id) {
        this.animalMybatisMapper.delete(id);
    }

    public List<AnimalDto> findWhere(SearchRequestDto search) {
        List<AnimalDto> where = this.animalMybatisMapper.findWhere(search);
        return where;
    }
}
