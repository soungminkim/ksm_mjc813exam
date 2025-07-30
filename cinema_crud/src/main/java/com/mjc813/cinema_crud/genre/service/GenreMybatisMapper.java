package com.mjc813.cinema_crud.genre.service;

import com.mjc813.cinema_crud.genre.dto.GenreDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenreMybatisMapper {
    public void insert(GenreDto dto);
}
