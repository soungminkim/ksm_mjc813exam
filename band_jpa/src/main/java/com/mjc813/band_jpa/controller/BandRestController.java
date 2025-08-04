package com.mjc813.band_jpa.controller;


import com.mjc813.band_jpa.common.ResponseDto;
import com.mjc813.band_jpa.dto.BandDto;
import com.mjc813.band_jpa.dto.BandEntity;
import com.mjc813.band_jpa.service.BandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/band")
public class BandRestController {
    @Autowired
    private BandService bandService;

    @GetMapping("")
    public ResponseEntity<ResponseDto> list() {
        List<BandEntity> bands = bandService.findAll();
        return ResponseEntity.ok(getResponseDto("success", 50000, bands));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getOne(@PathVariable Long id) {
        BandEntity band = bandService.findById(id);
        return ResponseEntity.ok(getResponseDto("success", 50000, band));
    }

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody BandDto dto) {
        try{
            BandEntity entity = bandService.insert(dto);
            return ResponseEntity.ok().body(
                    this.getResponseDto("success", 50000, entity)
            );
        } catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    this.getResponseDto("error",90000,dto)
            );
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Long id, @RequestBody BandDto dto) {
        BandEntity updated = bandService.update(id, dto);
        return ResponseEntity.ok(getResponseDto("success", 50000, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        bandService.delete(id);
        return ResponseEntity.ok(getResponseDto("success", 50000, null));
    }

    private ResponseDto getResponseDto(String message, int code, Object data) {
        return ResponseDto.builder()
                .message(message)
                .resultCode(code)
                .resultData(data)
                .build();
    }
}
