package com.mjc813.food_web.food_category.service;

import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.food_category.service.FoodCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodCategoryService {
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    public FoodCategoryDto insert(FoodCategoryDto dto) {
        FoodCategoryEntity entity = new FoodCategoryEntity();
        entity.setName(dto.getName());
        FoodCategoryEntity saved = foodCategoryRepository.save(entity);
        return toDto(saved);
    }

    public List<FoodCategoryDto> findAll() {
        List<FoodCategoryEntity> entities = foodCategoryRepository.findAll();
        List<FoodCategoryDto> result = new ArrayList<>();
        for (FoodCategoryEntity entity : entities) {
            result.add(toDto(entity));
        }
        return result;
    }

    public FoodCategoryDto findById(Long id) {
        FoodCategoryEntity entity = foodCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("카테고리 정보 없음"));
        return toDto(entity);
    }

    public FoodCategoryDto update(Long id, FoodCategoryDto dto) {
        FoodCategoryEntity entity = foodCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("카테고리 정보 없음"));
        entity.setName(dto.getName());
        FoodCategoryEntity updated = foodCategoryRepository.save(entity);
        return toDto(updated);
    }

    public void delete(Long id) {
        if (!foodCategoryRepository.existsById(id)) {
            throw new RuntimeException("이미 삭제되었거나 없는 카테고리입니다.");
        }
        foodCategoryRepository.deleteById(id);
    }

    private FoodCategoryDto toDto(FoodCategoryEntity entity) {
        return new FoodCategoryDto(entity.getId(), entity.getName());
    }
}
