package com.mjc813.food_web.food_ingredient.service;

import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food_ingredient.dto.FoodIngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodIngredientRepository extends JpaRepository<FoodIngredientEntity, Long> {
    List<FoodIngredientEntity> findAllByOrderByIdDesc();
    List<FoodIngredientEntity> findByFoodEntityOrderByFoodEntityAsc(FoodEntity foodEntity);
    void deleteAllByFoodEntity(FoodEntity foodEntity);
}
