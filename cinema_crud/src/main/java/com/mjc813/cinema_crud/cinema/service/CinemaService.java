package com.mjc813.cinema_crud.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    @Autowired
    private CinemaMybatisMapper cinemaMybatisMapper;
}
