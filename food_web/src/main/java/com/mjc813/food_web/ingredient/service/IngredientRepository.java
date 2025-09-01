package com.mjc813.food_web.ingredient.service;

import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
    List<IngredientEntity> findAllByOrderByIdDesc();
}
