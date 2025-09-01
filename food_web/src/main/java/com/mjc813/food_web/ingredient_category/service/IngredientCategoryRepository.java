package com.mjc813.food_web.ingredient_category.service;

import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientCategoryRepository extends JpaRepository<IngredientCategoryEntity, Long> {
    List<IngredientCategoryEntity> findAllByOrderByIdDesc();
    Page<IngredientCategoryEntity> findByNameContains(String name, Pageable pageable);
}
