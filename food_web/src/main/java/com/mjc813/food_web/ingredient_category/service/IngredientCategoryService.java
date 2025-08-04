package com.mjc813.food_web.ingredient_category.service;

import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import com.mjc813.food_web.ingredient_category.service.IngredientCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientCategoryService {
    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    // 등록(Create)
    public IngredientCategoryDto insert(IngredientCategoryDto dto) {
        IngredientCategoryEntity entity = new IngredientCategoryEntity();
        entity.setName(dto.getName());
        IngredientCategoryEntity saved = ingredientCategoryRepository.save(entity);
        return toDto(saved);
    }

    // 전체조회(Read)
    public List<IngredientCategoryDto> findAll() {
        List<IngredientCategoryEntity> entities = ingredientCategoryRepository.findAll();
        List<IngredientCategoryDto> result = new ArrayList<>();
        for (IngredientCategoryEntity entity : entities) {
            result.add(toDto(entity));
        }
        return result;
    }

    // 단일조회(Read)
    public IngredientCategoryDto findById(Long id) {
        IngredientCategoryEntity entity = ingredientCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("카테고리 정보 없음"));
        return toDto(entity);
    }

    // 수정(Update)
    public IngredientCategoryDto update(Long id, IngredientCategoryDto dto) {
        IngredientCategoryEntity entity = ingredientCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("카테고리 정보 없음"));
        entity.setName(dto.getName());
        IngredientCategoryEntity updated = ingredientCategoryRepository.save(entity);
        return toDto(updated);
    }

    // 삭제(Delete)
    public void delete(Long id) {
        if (!ingredientCategoryRepository.existsById(id)) {
            throw new RuntimeException("이미 삭제되었거나 없는 카테고리입니다.");
        }
        ingredientCategoryRepository.deleteById(id);
    }

    // Entity -> DTO 변환 메서드
    private IngredientCategoryDto toDto(IngredientCategoryEntity entity) {
        return new IngredientCategoryDto(
                entity.getId(),
                entity.getName()
        );
    }
}
