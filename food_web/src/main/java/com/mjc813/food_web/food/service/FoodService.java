package com.mjc813.food_web.food.service;

import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.food_category.service.FoodCategoryRepository;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import com.mjc813.food_web.ingredient.service.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Transactional
    public FoodDto insertFood(FoodDto dto) {
        IngredientEntity ingredient = ingredientRepository.findById(dto.getIngredientId())
                .orElseThrow(() -> new IllegalArgumentException("재료 정보 없음"));

        FoodCategoryEntity foodCategory = foodCategoryRepository.findById(dto.getFoodCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("카테고리 정보 없음"));

        FoodEntity foodEntity = FoodEntity.builder()
                .name(dto.getName())
                .spicyLevel(dto.getSpicyLevel())
                .sweetLevel(dto.getSweetLevel())
                .sourLevel(dto.getSourLevel())
                .saltyLevel(dto.getSaltyLevel())
                .ingredient(ingredient)
                .foodCategory(foodCategory)
                .build();

        FoodEntity savedEntity = foodRepository.save(foodEntity);
        return toDto(savedEntity);
    }

    public List<FoodDto> findAll() {
        return foodRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public FoodDto findById(Long id) {
        FoodEntity entity = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("음식 정보 없음"));
        return toDto(entity);
    }

    @Transactional
    public FoodDto update(Long id, FoodDto dto) {
        FoodEntity entity = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("음식 정보 없음"));

        IngredientEntity ingredient = ingredientRepository.findById(dto.getIngredientId())
                .orElseThrow(() -> new RuntimeException("재료 정보 없음"));

        FoodCategoryEntity foodCategory = foodCategoryRepository.findById(dto.getFoodCategoryId())
                .orElseThrow(() -> new RuntimeException("카테고리 정보 없음"));

        // 공용 인터페이스의 디폴트 메서드와 빌더를 함께 활용
        entity.copyMembers(dto); // IFood의 기본 멤버 복사
        entity.setIngredient(ingredient);
        entity.setFoodCategory(foodCategory);

        FoodEntity updated = foodRepository.save(entity);
        return toDto(updated);
    }

    @Transactional
    public void delete(Long id) {
        if (!foodRepository.existsById(id)) {
            throw new RuntimeException("이미 삭제되었거나 없는 음식입니다.");
        }
        foodRepository.deleteById(id);
    }

    public FoodDto toDto(FoodEntity entity) {
        Long ingredientId = (entity.getIngredient() != null) ? entity.getIngredient().getId() : null;
        Long foodCategoryId = (entity.getFoodCategory() != null) ? entity.getFoodCategory().getId() : null;

        return FoodDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .spicyLevel(entity.getSpicyLevel())
                .sweetLevel(entity.getSweetLevel())
                .sourLevel(entity.getSourLevel())
                .saltyLevel(entity.getSaltyLevel())
                .ingredientId(ingredientId)
                .foodCategoryId(foodCategoryId)
                .ingredient(entity.getIngredient())
                .foodCategory(entity.getFoodCategory())
                .build();
    }
}