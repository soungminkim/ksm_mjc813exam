package com.mjc813.cinema_jpa.cinema.service;

import com.mjc813.cinema_jpa.cinema.dto.CinemaDto;
import com.mjc813.cinema_jpa.cinema.dto.CinemaEntity;
import com.mjc813.cinema_jpa.cinema.dto.CinemaGenreDto;
import com.mjc813.cinema_jpa.cinema.dto.ICinema;
import com.mjc813.cinema_jpa.genre.dto.GenreDto;
import com.mjc813.cinema_jpa.genre.dto.GenreEntity;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public ICinema insertCinema(CinemaDto dto) {
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setId(dto.getGenreId());

        CinemaEntity entity = new CinemaEntity();
        entity.setGenre(genreEntity);
        entity.copyMembers(dto);
        this.cinemaRepository.save(entity);
        return entity;
    }

    @Transactional
    public void insertCinemaWithGenre(CinemaGenreDto dto) {
//        GenreDto genreDto = new GenreDto();
//        genreDto.setName(dto.getGenreName());
//
//        this.genreMybatisMapper.insert(genreDto);
//        dto.setGenreId(genreDto.getId());
//
//        this.cinemaMybatisMapper.insertCinema(dto);
//        dto.setGenreName(genreDto.getName());
    }

    public CinemaEntity findById(Long id) {
        Optional<CinemaEntity> find = this.cinemaRepository.findById(id);
        return find.orElse(null);
    }

    public List<CinemaGenreDto> findByWhere() {
//        return this.cinemaMybatisMapper.findByWhere();
        return null;
    }

    public void update(CinemaEntity object) {
        this.cinemaRepository.save(object);
        object.setDescription("컨트롤러에서 수정함");
        this.cinemaRepository.flush();
    }

    public void delete(Long id) {
//        this.cinemaMybatisMapper.delete(id);
    }
}
