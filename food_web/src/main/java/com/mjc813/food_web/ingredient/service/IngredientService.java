package com.mjc813.food_web.ingredient.service;

import com.mjc813.food_web.ingredient.dto.IngredientDto;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import com.mjc813.food_web.ingredient_category.service.IngredientCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    @Transactional
    public IngredientDto insert(IngredientDto dto) {
        IngredientCategoryEntity category = ingredientCategoryRepository.findById(dto.getIngredientCategoryId())
                .orElseThrow(() -> new RuntimeException("카테고리 정보 없음"));

        IngredientEntity entity = IngredientEntity.builder()
                .name(dto.getName())
                .ingredientCategory(category)
                .build();

        IngredientEntity saved = ingredientRepository.save(entity);
        return toDto(saved);
    }

    public List<IngredientDto> findAll() {
        return ingredientRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public IngredientDto findById(Long id) {
        IngredientEntity entity = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("재료 정보 없음"));
        return toDto(entity);
    }

    @Transactional
    public IngredientDto update(Long id, IngredientDto dto) {
        IngredientEntity entity = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("재료 정보 없음"));

        IngredientCategoryEntity category = ingredientCategoryRepository.findById(dto.getIngredientCategoryId())
                .orElseThrow(() -> new RuntimeException("카테고리 정보 없음"));

        entity.setName(dto.getName());
        entity.setIngredientCategory(category);

        IngredientEntity updated = ingredientRepository.save(entity);
        return toDto(updated);
    }

    @Transactional
    public void delete(Long id) {
        if (!ingredientRepository.existsById(id)) {
            throw new RuntimeException("이미 삭제되었거나 없는 재료입니다.");
        }
        ingredientRepository.deleteById(id);
    }

    private IngredientDto toDto(IngredientEntity entity) {
        return IngredientDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .ingredientCategoryId(entity.getIngredientCategoryId())
                .build();
    }
}