package com.mjc813.food_web.food.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto implements IFood{
   private Long id;
   private String name;
   private Integer spicyLevel;
   private Integer sweetLevel;
   private Integer sourLevel;
   private Integer saltyLevel;
   private Long ingredientId;
   private Long foodCategoryId;
}
