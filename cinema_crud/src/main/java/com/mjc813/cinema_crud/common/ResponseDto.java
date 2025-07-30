package com.mjc813.cinema_crud.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto {
    // http 요청에 대한 응답을 설계한 데이터형
    private Integer code;  // Code 처럼 사용할 응답
    private ResponseEnum responseEnum;  // Code 처럼 사용할 응답
    //    private String message;     // 출력할 응답 문자열
    private Object data;        // 출력할 응답 객게 멤버변수
}