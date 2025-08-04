package com.mjc813.cinema_crud.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {
    private String message;
    private Integer resultCode;
    private Object resultData;
}
