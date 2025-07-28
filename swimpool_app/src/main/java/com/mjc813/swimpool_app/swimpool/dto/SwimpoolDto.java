package com.mjc813.swimpool_app.swimpool.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwimpoolDto {
    private Integer id;
    private String name;
    private Integer lanes;
    private String laneType;
    private String phoneNumber;
    private String addr;
}
