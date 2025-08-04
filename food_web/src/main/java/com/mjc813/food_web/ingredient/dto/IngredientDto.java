package com.mjc813.food_web.ingredient.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto {
    private Long id;
    private String name;
    private Long ingredientCategoryId;
}
