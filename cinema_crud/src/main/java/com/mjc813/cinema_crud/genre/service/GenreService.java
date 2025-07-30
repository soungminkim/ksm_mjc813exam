package com.mjc813.cinema_crud.genre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    private GenreMybatisMapper genreMybatisMapper;
}
