package com.mjc813.food_web.food_ingredient.service;

import com.mjc813.food_web.food_ingredient.dto.FoodIngredientDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodIngredientMapper {
    void insert(FoodIngredientDto dto);
    void update(FoodIngredientDto dto);
    void delete(Long id);
    FoodIngredientDto findById(Long id);
    List<FoodIngredientDto> findAll();
}
