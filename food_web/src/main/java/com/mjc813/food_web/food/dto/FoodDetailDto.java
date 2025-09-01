package com.mjc813.food_web.food.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDetailDto extends FoodDto {
    private String foodCategoryName;
//    private String ingredientName;
//    private String ingredientCategoryName;
}
