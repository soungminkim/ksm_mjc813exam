package com.mjc813.food_web.ingredient_category.dto;

import com.mjc813.food_web.common.IIdName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientCategoryDto implements IIdName {
    private Long id;
    private String name;
}
