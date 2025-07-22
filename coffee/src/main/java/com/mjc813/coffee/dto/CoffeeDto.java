package com.mjc813.coffee.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeDto {
    private Long id;
    private String name;
    private Integer price;
    private String source;
    private Integer shots;
}
