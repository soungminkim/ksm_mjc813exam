package com.mjc813.food_web.food_category.service;

import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "food_category")
public interface FoodCategoryRepository extends JpaRepository<FoodCategoryEntity, Long> {

}
