package com.mjc813.food_web.common.dto;

import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileRestResponseDto {
    private FoodCategoryDto foodCategoryDto;
    private List<String> files;
}
