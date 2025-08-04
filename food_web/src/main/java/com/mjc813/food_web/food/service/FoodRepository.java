package com.mjc813.food_web.food.service;

import com.mjc813.food_web.food.dto.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "food")
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

}
