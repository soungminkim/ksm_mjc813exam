package com.mjc813.cinema_jpa.genre.controller;


import com.mjc813.cinema_jpa.common.ResponseDto;
import com.mjc813.cinema_jpa.genre.dto.GenreDto;
import com.mjc813.cinema_jpa.genre.dto.GenreEntity;
import com.mjc813.cinema_jpa.genre.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/genre")
public class GenreRestController {
    @Autowired
    private GenreService genreService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody GenreDto dto) {
        try {
            GenreEntity entity = this.genreService.insert(dto);
            return ResponseEntity.ok(
                    this.getResponseDto("success", 50010, entity)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    this.getResponseDto("error", 90000, dto)
            );
        }
    }

    private ResponseDto getResponseDto(String msg, Integer code, Object data) {
        return ResponseDto.builder()
                .message(msg)
                .resultCode(code)
                .resultData(data)
                .build();
    }

    @GetMapping("/in/{name}")
    public ResponseEntity<ResponseDto> find(@PathVariable String name) {
        try {
            List<GenreEntity> list = this.genreService.findByNameContains(name);
            return ResponseEntity.ok(
                    this.getResponseDto("success", 50010, list)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    this.getResponseDto("error", 90000, name)
            );
        }
    }

    @GetMapping("/by/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            GenreEntity data = this.genreService.findById(id);
            return ResponseEntity.ok(
                    this.getResponseDto("success", 50010, data)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    this.getResponseDto("error", 90000, id)
            );
        }
    }

    @GetMapping("/gt/{id}")
    public ResponseEntity<ResponseDto> findByIdGreaterThan(@PathVariable Long id) {
        try {
            List<GenreEntity> list = this.genreService.findByIdGreaterThan(id);
            return ResponseEntity.ok(
                    this.getResponseDto("success", 50010, list)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.status(500).body(
                    this.getResponseDto("error", 90000, id)
            );
        }
    }
}
