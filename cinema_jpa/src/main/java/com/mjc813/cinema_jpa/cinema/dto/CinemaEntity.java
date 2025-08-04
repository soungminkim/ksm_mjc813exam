package com.mjc813.cinema_jpa.cinema.dto;

import com.mjc813.cinema_jpa.genre.dto.GenreEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CinemaEntity")
@Table(name = "cinema2_tbl")
public class CinemaEntity implements ICinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id              ;

    @Column(length = 20, unique = true, nullable = false)
    private String  name            ;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre       ;

    @Column(length = 20, nullable = false)
    private String  playTime        ;

    @Column(length = 100, nullable = false)
    private String  casts           ;

    @Column(length = 2000)
    private String  description     ;

    @Column(nullable = false)
    private Integer restrictAge     ;

    @Override
    public Long getGenreId() {
        if (this.genre == null) {
            return 0L;
        }
        return this.genre.getId();
    }

    @Override
    public void setGenreId(Long genreId) {
        if (this.genre == null) {
            return;
        }
        this.genre.setId(genreId);
    }
}
