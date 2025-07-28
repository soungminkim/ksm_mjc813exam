package com.mjc813.swimpool_app.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {
    private ResponseEnum responseEnum;
    private String message;
    private Object data;
}
