package com.mjc813.swimpool_app.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {
    // 공통응답에 대한 Dto
    private ResponseEnum responseEnum;
    private String message;
    private Object data;
    private Integer code;
}
