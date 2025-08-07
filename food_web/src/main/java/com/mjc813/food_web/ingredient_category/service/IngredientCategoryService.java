package com.mjc813.food_web.ingredient_category.service;

import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientCategoryService {

    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    @Transactional
    public IngredientCategoryDto insert(IngredientCategoryDto dto) {
        IngredientCategoryEntity entity = IngredientCategoryEntity.builder()
                .name(dto.getName())
                .build();
        IngredientCategoryEntity saved = ingredientCategoryRepository.save(entity);
        return toDto(saved);
    }

    public List<IngredientCategoryDto> findAll() {
        return ingredientCategoryRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public IngredientCategoryDto findById(Long id) {
        IngredientCategoryEntity entity = ingredientCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("카테고리 정보 없음: " + id));
        return toDto(entity);
    }

    @Transactional
    public IngredientCategoryDto update(Long id, IngredientCategoryDto dto) {
        IngredientCategoryEntity entity = ingredientCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("수정할 카테고리 정보 없음: " + id));

        entity.copyIdNameNotNull(dto);

        IngredientCategoryEntity updated = ingredientCategoryRepository.save(entity);
        return toDto(updated);
    }

    @Transactional
    public void delete(Long id) {
        if (!ingredientCategoryRepository.existsById(id)) {
            throw new RuntimeException("이미 삭제되었거나 없는 카테고리입니다.");
        }
        ingredientCategoryRepository.deleteById(id);
    }

    private IngredientCategoryDto toDto(IngredientCategoryEntity entity) {
        return IngredientCategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}