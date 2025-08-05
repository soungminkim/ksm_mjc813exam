package com.mjc813.food_web.food.service;

import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food.dto.IFood;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.food_category.service.FoodCategoryRepository;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import com.mjc813.food_web.ingredient.service.IngredientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Transactional
    public FoodEntity insertFood(FoodDto dto) {
        IngredientEntity ingredient = ingredientRepository.findById(dto.getIngredientId())
                .orElseThrow(() -> new IllegalArgumentException("재료 정보 없음"));

        FoodCategoryEntity foodCategory = foodCategoryRepository.findById(dto.getFoodCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("카테고리 정보 없음"));

        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setIngredient(ingredient);
        foodEntity.setFoodCategory(foodCategory);
        foodEntity.setName(dto.getName());
        foodEntity.setSpicyLevel(dto.getSpicyLevel());
        foodEntity.setSweetLevel(dto.getSweetLevel());
        foodEntity.setSourLevel(dto.getSourLevel());
        foodEntity.setSaltyLevel(dto.getSaltyLevel());
        return foodRepository.save(foodEntity);
    }


    public List<FoodDto> findAll() {
        List<FoodEntity> foods = foodRepository.findAll();
        List<FoodDto> result = new ArrayList<>();
        for (FoodEntity entity : foods) {
            result.add(toDto(entity));
        }
        return result;
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

        entity.setName(dto.getName());
        entity.setSpicyLevel(dto.getSpicyLevel());
        entity.setSweetLevel(dto.getSweetLevel());
        entity.setSourLevel(dto.getSourLevel());
        entity.setSaltyLevel(dto.getSaltyLevel());
        entity.setIngredient(ingredient);
        entity.setFoodCategory(foodCategory);

        FoodEntity updated = foodRepository.save(entity);
        return toDto(updated);
    }


    public void delete(Long id) {
        if (!foodRepository.existsById(id)) {
            throw new RuntimeException("이미 삭제되었거나 없는 음식입니다.");
        }
        foodRepository.deleteById(id);
    }

    public FoodDto toDto(FoodEntity entity) {
        return new FoodDto(
                entity.getId(),
                entity.getName(),
                entity.getSpicyLevel(),
                entity.getSweetLevel(),
                entity.getSourLevel(),
                entity.getSaltyLevel(),
                entity.getIngredient() != null ? entity.getIngredient().getId() : null,
                entity.getFoodCategory() != null ? entity.getFoodCategory().getId() : null
        );
    }
}
