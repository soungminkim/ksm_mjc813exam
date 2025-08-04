package com.mjc813.cinema_crud.cinema.controller;

import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import com.mjc813.cinema_crud.cinema.dto.CinemaGenreDto;
import com.mjc813.cinema_crud.cinema.service.CinemaService;
import com.mjc813.cinema_crud.common.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cinema")
public class CinemaRestController {
    @Autowired
    private CinemaService cinemaService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insertCinema(@Validated @RequestBody CinemaDto dto) {
        try {
            this.cinemaService.insertCinema(dto);
            return ResponseEntity.ok().body(
                new ResponseDto("ok", 50010, dto)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                new ResponseDto("insert error", 90000, dto)
            );
        }
    }

    @PostMapping("/genre")
    public ResponseEntity<ResponseDto> insert2Genre(@RequestBody CinemaGenreDto dto) {
        try {
            this.cinemaService.insertCinemaWithGenre(dto);
            return ResponseEntity.ok().body(
                    new ResponseDto("ok", 50010, dto)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    new ResponseDto("insert error", 90000, dto)
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            CinemaDto find = this.cinemaService.findById(id);
            if ( find == null ) {
                return ResponseEntity.status(610).body(
                        new ResponseDto("not found", 49999, id)
                );
            } else {
                return ResponseEntity.ok().body(
                        new ResponseDto("suceess", 40010, find)
                );
            }
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    new ResponseDto("findById error", 90000, id)
            );
        }
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDto> findByWhere() {
        try {
            List<CinemaGenreDto> list = this.cinemaService.findByWhere();
            return ResponseEntity.ok().body(
                    new ResponseDto("success", 40050, list)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    new ResponseDto("findByWhere error", 90000, null)
            );
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@RequestBody CinemaDto dto) {
        try {
            this.cinemaService.update(dto);
            return ResponseEntity.ok().body(
                    new ResponseDto("success", 40090, dto)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    new ResponseDto("update error", 90000, null)
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        try {
            this.cinemaService.delete(id);
            return ResponseEntity.ok().body(
                    new ResponseDto("success", 40030, true)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    new ResponseDto("delete error", 90000, null)
            );
        }
    }
}
