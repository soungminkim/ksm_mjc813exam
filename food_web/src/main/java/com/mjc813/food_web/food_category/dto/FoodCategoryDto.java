package com.mjc813.food_web.food_category.dto;

import com.mjc813.food_web.common.IIdName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategoryDto implements IIdName {
    private Long id;
    private String name;
}
