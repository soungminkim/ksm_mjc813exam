package com.mjc813.food_web.food_category.dto;

import com.mjc813.food_web.common.IIdName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodCategoryDto implements IIdName {
    private Long id;
    private String name;
}