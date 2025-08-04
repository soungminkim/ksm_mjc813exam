package com.mjc813.cinema_crud.cinema.dto;

import com.mjc813.cinema_crud.genre.dto.GenreDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaGenreDto extends CinemaDto {
    private String genreName;
}
