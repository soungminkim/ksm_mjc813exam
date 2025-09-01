package com.mjc813.food_web.ingredient_category.service;

import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IngredientCategoryMapper {
    void insert(IngredientCategoryDto dto);
    void update(IngredientCategoryDto dto);
    void delete(Long id);
    IngredientCategoryDto findById(Long id);
    List<IngredientCategoryDto> findAll();
}
