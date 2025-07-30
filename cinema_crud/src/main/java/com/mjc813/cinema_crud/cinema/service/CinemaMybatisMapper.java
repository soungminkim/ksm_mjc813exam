package com.mjc813.cinema_crud.cinema.service;

import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CinemaMybatisMapper {
    public void insertCinema(CinemaDto dto);
}
