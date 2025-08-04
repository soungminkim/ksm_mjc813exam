package com.mjc813.food_web.ingredient.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDto {
    private Long id;
    private String name;
    private Long ingredientCategoryId;
}
