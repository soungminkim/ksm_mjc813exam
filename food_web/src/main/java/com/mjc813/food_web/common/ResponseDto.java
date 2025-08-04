package com.mjc813.food_web.common;

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
