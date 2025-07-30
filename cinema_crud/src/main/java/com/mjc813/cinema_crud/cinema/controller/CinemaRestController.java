package com.mjc813.cinema_crud.cinema.controller;

import com.mjc813.cinema_crud.cinema.dto.CinemaDto;
import com.mjc813.cinema_crud.cinema.service.CinemaService;
import com.mjc813.cinema_crud.common.ResponseDto;
import com.mjc813.cinema_crud.common.ResponseEnum;
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
@RequestMapping("/cinema")
public class CinemaRestController {
    @Autowired
    private CinemaService cinemaService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody CinemaDto dto) {
        try {
            this.cinemaService.insert(dto);
            ResponseDto result = ResponseDto.builder()
                    .message("success")
                    .resultCode(50000)
                    .resultData(dto)
                    .build();
            return ResponseEntity.ok(result);
        } catch (Throwable e){
            log.error(e.toString());
            ResponseDto result = ResponseDto.builder()
                    .message("Cinema Insert Error")
                    .resultCode(ResponseEnum.CinemaInsertFail.getCode())
                    .resultData(null)
                    .build();
            return ResponseEntity.status(500).body(result);
        }
    }
}
