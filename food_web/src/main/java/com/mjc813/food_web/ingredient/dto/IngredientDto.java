package com.mjc813.food_web.ingredient.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientDto implements IIngredient {
    private Long id;
    private String name;
    private Long ingredientCategoryId;

    @JsonIgnore
    private IIdName ingredientCategory;

    public IngredientDto(Long id, String name, Long ingredientCategoryId) {
        this.id = id;
        this.name = name;
        this.ingredientCategoryId = ingredientCategoryId;
    }
}