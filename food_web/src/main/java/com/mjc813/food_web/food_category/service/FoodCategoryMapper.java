package com.mjc813.food_web.food_category.service;

import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodCategoryMapper {
    void insert(FoodCategoryDto dto);
    void update(FoodCategoryDto dto);
    void delete(Long id);
    FoodCategoryDto findById(Long id);
    List<FoodCategoryDto> findAll();
}
