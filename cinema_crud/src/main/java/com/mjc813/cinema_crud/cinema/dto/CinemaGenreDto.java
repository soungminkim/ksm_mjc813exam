package com.mjc813.cinema_crud.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaGenreDto {
    private Long id;
    private String name;
    private String genre;
    private String playTime;
    private String casts;
    private String description;
    private Integer restrictAge;
}

