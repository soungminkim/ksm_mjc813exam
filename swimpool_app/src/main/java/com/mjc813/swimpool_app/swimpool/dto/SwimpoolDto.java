package com.mjc813.swimpool_app.swimpool.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwimpoolDto {
    // DB에 존재하는 컬럼 정보
    private Integer id;

    @Size(min=4, max=30)
    private String name;

    @Min(1)
    private Integer lanes;

    private String laneType;
    private String phoneNumber;
    private String addr;
}
