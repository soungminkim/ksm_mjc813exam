package com.mjc813.food_web.food_file.service;

import com.mjc813.food_web.food_file.dto.FoodFileDto;
import com.mjc813.food_web.food_file.dto.FoodFileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodFileService {
    @Autowired
    private FoodFileRepository foodFileRepository;

    public void insert(FoodFileDto foodFileDto) {
        FoodFileEntity foodFileEntity = new FoodFileEntity();
        foodFileEntity.copyMembersFoodFile(foodFileDto);
        this.foodFileRepository.save(foodFileEntity);
    }

    public void update(FoodFileDto foodFileDto) {
        FoodFileEntity foodFileEntity = new FoodFileEntity();
        foodFileEntity.copyMembersNotNullFoodFile(foodFileDto);
        this.foodFileRepository.save(foodFileEntity);
    }
}
