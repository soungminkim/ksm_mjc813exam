package com.mjc813.mpacrud.animal.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalDto {
    private Long id;
    private String name;
    private Integer age;
    private String kind;
}
