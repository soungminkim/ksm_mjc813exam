package com.mjc813.food_web.food.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.food_web.common.IIdName;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDto implements IFood {
   private Long id;
   private String name;

   @NotNull(message = "매운맛 레벨은 비워둘 수 없습니다.")
   @Min(value = 1, message = "맛 레벨은 1 이상이어야 합니다.")
   private Integer spicyLevel;

   @NotNull(message = "단맛 레벨은 비워둘 수 없습니다.")
   @Min(value = 1, message = "맛 레벨은 1 이상이어야 합니다.")
   private Integer sweetLevel;

   @NotNull(message = "신맛 레벨은 비워둘 수 없습니다.")
   @Min(value = 1, message = "맛 레벨은 1 이상이어야 합니다.")
   private Integer sourLevel;

   @NotNull(message = "짠맛 레벨은 비워둘 수 없습니다.")
   @Min(value = 1, message = "맛 레벨은 1 이상이어야 합니다.")
   private Integer saltyLevel;

   @NotNull(message = "주재료는 필수입니다.")
   private Long ingredientId;

   @NotNull(message = "음식 카테고리는 필수입니다.")
   private Long foodCategoryId;

   @JsonIgnore
   private IIdName ingredient;
   @JsonIgnore
   private IIdName foodCategory;
}