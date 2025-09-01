package com.mjc813.food_web.food.service;

import com.mjc813.food_web.food.dto.FoodDetailDto;
import com.mjc813.food_web.food.dto.FoodDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface FoodMapper {
    void insert(FoodDto dto);
    void update(FoodDto dto);
    void delete(Long id);
    FoodDto findById(Long id);
    List<FoodDetailDto> findAll();

    Long countBySearch(String name, Long foodCategoryId);
    List<FoodDetailDto> findBySearch(String name, Long foodCategoryId, Pageable pageable);
}
