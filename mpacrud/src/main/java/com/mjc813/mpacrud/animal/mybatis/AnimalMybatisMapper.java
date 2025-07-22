package com.mjc813.mpacrud.animal.mybatis;

import com.mjc813.mpacrud.animal.dto.AnimalDto;
import com.mjc813.mpacrud.animal.dto.SearchRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // resources/mapper/**/*.xml 파일중에서
// <mapper namespace="com.mjc813.mpacrud.animal.mybatis.AnimalMybatisMapper">
// SQL 쿼리 문장의 태그들을 메소드로 만들어 준다.
public interface AnimalMybatisMapper {
    public void insertAnimal(AnimalDto animalDto);
    public List<AnimalDto> findAll();
    public AnimalDto findById(Long id);
    public void update(AnimalDto dto);
    public void delete(Long id);
    public List<AnimalDto> findWhere(SearchRequestDto search);
}
