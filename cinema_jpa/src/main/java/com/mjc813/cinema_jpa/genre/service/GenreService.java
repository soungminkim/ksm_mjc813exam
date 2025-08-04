package com.mjc813.cinema_jpa.genre.service;

import com.mjc813.cinema_jpa.genre.dto.GenreDto;
import com.mjc813.cinema_jpa.genre.dto.GenreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public GenreEntity insert(GenreDto dto) {
        GenreEntity entity = new GenreEntity(null, dto.getName(), dto.getRestrictAge());
        this.genreRepository.save(entity);
        return entity;
    }

    public List<GenreEntity> findByNameContains(String name) {
        return this.genreRepository.findByNameContains(name);
    }

    public GenreEntity findById(Long id) {
        Optional<GenreEntity> find = this.genreRepository.findById(id);
        return find.orElse(null);
    }

    public List<GenreEntity> findByIdGreaterThan(Long id) {
        return this.genreRepository.findByIdGreaterThan(id);
    }
}
