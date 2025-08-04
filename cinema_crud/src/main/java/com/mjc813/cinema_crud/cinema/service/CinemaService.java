package com.mjc813.cinema_crud.cinema.service;

import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import com.mjc813.cinema_crud.cinema.dto.CinemaGenreDto;
import com.mjc813.cinema_crud.genre.dto.GenreDto;
import com.mjc813.cinema_crud.genre.service.GenreMybatisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CinemaService {
    @Autowired
    private CinemaMybatisMapper cinemaMybatisMapper;

    @Autowired
    private GenreMybatisMapper genreMybatisMapper;

    public void insertCinema(CinemaDto dto) {
        this.cinemaMybatisMapper.insertCinema(dto);
    }

    @Transactional
    public void insertCinemaWithGenre(CinemaGenreDto dto) {
        GenreDto genreDto = new GenreDto();
        genreDto.setName(dto.getGenreName());

        this.genreMybatisMapper.insert(genreDto);
        dto.setGenreId(genreDto.getId());

        this.cinemaMybatisMapper.insertCinema(dto);
        dto.setGenreName(genreDto.getName());
    }

    public CinemaDto findById(Long id) {
        return this.cinemaMybatisMapper.findById(id);
    }

    public List<CinemaGenreDto> findByWhere() {
        return this.cinemaMybatisMapper.findByWhere();
    }

    public void update(CinemaDto dto) {
        this.cinemaMybatisMapper.update(dto);
    }

    public void delete(Long id) {
        this.cinemaMybatisMapper.delete(id);
    }
}
