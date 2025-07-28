package com.mjc813.swimpool_app.swimpool.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwimpoolDto {
    // DB에 존재하는 컬럼 정보
    private Integer id;
    private String name;
    private Integer lanes;
    private String laneType;
    private String phoneNumber;
    private String addr;
}
