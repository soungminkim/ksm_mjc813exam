package com.mjc813.food_web.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnumRestConroller {

    @GetMapping("/api/v1/erole")
    public ResponseEntity<ResponseDto> getERoles() {
        ERole[] list = ERole.values();
        return ResponseEntity.ok().body(
                ResponseDto.builder()
                        .code(ResponseCode.SUCCESS)
                        .message("OK")
                        .result(list)
                        .build()
        );
    }
}
