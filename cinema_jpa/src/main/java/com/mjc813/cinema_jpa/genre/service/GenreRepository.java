package com.mjc813.cinema_jpa.genre.service;

import com.mjc813.cinema_jpa.genre.dto.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "genre2")
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    List<GenreEntity> findByNameContains(String name);

    List<GenreEntity> findByIdGreaterThan(Long idIsGreaterThan);
    
    List<GenreEntity> findByNameContainsAndRestrictAgeGreaterThanEqual(String name, Integer restrictAgeIsGreaterThan);
}
