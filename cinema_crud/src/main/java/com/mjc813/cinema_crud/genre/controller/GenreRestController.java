package com.mjc813.cinema_crud.genre.controller;

import com.mjc813.cinema_crud.common.ResponseDto;
import com.mjc813.cinema_crud.genre.dto.GenreDto;
import com.mjc813.cinema_crud.genre.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/genre")
public class GenreRestController {
    @Autowired
    private GenreService genreService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody GenreDto dto) {
        try {
            this.genreService.insert(dto);
            ResponseDto result = ResponseDto.builder()
                    .message("success")
                    .resultCode(50010)
                    .resultData(dto)
                    .build();
            return ResponseEntity.ok(result);
        } catch (Throwable e) {
            log.error(e.toString());
            ResponseDto result = ResponseDto.builder()
                    .message("error")
                    .resultCode(90000)
                    .resultData(null)
                    .build();
            return ResponseEntity.status(500).body(result);
        }
    }
}
