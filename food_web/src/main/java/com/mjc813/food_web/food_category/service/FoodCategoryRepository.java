package com.mjc813.food_web.food_category.service;

import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategoryEntity, Long> {
    List<FoodCategoryEntity> findAllByOrderByIdDesc();
    Page<FoodCategoryEntity> findByNameContains(String name, Pageable pageable);
}
