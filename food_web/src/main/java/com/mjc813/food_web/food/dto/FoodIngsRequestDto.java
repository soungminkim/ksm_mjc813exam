package com.mjc813.food_web.food.dto;

import com.mjc813.food_web.food_ingredient.dto.FoodIngredientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class FoodIngsRequestDto {
    private FoodDto food;

    private List<FoodIngredientDto> foodIngs;
}
