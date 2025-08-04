package com.mjc813.cinema_jpa.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDto implements ICinema {
    private Long    id              ;
    private String  name            ;
    private Long    genreId         ;
    private String  playTime        ;
    private String  casts           ;
    private String  description     ;
    private Integer restrictAge     ;
}
