package com.mjc813.food_web.common;

import org.springframework.http.ResponseEntity;

public class CommonRestController {
    public ResponseEntity<ResponseDto> getReponseEntity(ResponseCode code, String message, Object data, Throwable th) {
        if ( th == null ) {
            return ResponseEntity.ok().body(
                    ResponseDto.builder()
                            .code(code)
                            .message(message)
                            .result(data)
                            .build()
            );
        } else {
            ResponseEntity<ResponseDto> result = ResponseEntity.status(500).body(
                    ResponseDto.builder()
                    .code(code)
                    .message(message)
                    .result(data)
                    .build()
            );
            return result;
        }
    }
}
