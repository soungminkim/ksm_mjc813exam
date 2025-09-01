package com.mjc813.food_web.food_ingredient.service;

import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food_ingredient.dto.FoodIngredientDto;
import com.mjc813.food_web.food_ingredient.dto.FoodIngredientEntity;
import com.mjc813.food_web.food_ingredient.dto.IFoodIngredient;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodIngredientService {
    @Autowired
    private FoodIngredientMapper mapper;

    @Autowired
    private FoodIngredientRepository repository;

    public IFoodIngredient insertRepository(FoodIngredientDto dto) {
        FoodIngredientEntity entity = new FoodIngredientEntity();
        entity.copyMembersFoodIngredient(dto);
        FoodIngredientEntity result = this.repository.save(entity);
        return result;
    }

    public IFoodIngredient insertMybatis(FoodIngredientDto dto) {
        this.mapper.insert(dto);
        return dto;
    }

    public IFoodIngredient updateRepository(FoodIngredientDto dto) {
        return this.insertRepository(dto);
    }

    public IFoodIngredient updateMybatis(FoodIngredientDto dto) {
        this.mapper.update(dto);
        return dto;
    }

    public Boolean deleteRepository(Long id) {
        this.repository.deleteById(id);
        return true;
    }

    public Boolean deleteMybatis(Long id) {
        this.mapper.delete(id);
        return true;
    }

    public IFoodIngredient findByIdRepository(Long id) throws Exception {
        Optional<FoodIngredientEntity> find = this.repository.findById(id);
        if ( find.isPresent() ) {
            return find.get();
        } else {
            throw new NotFoundException(String.format("data cat not found [%d]", id));
        }
    }

    public IFoodIngredient findByIdMybatis(Long id) throws Exception {
        FoodIngredientDto find = this.mapper.findById(id);
        if ( find != null ) {
            return find;
        } else {
            throw new NotFoundException(String.format("data cat not found [%d]", id));
        }
    }

    public List<IFoodIngredient> findAllRepository() {
        List<FoodIngredientEntity> all = this.repository.findAllByOrderByIdDesc();
        List<IFoodIngredient> result = all.parallelStream()
                .map(x -> (IFoodIngredient)x).toList();
        return result;
    }

    public List<IFoodIngredient> findAllMybatis() {
        List<FoodIngredientDto> all = this.mapper.findAll();
        List<IFoodIngredient> result = all.parallelStream()
                .map(x -> (IFoodIngredient)x).toList();
        return result;
    }

    public List<FoodIngredientEntity> findByFoodEntityOrderByFoodEntityAsc(Long foodId) {
        FoodEntity entity = FoodEntity.builder().id(foodId).build();
        List<FoodIngredientEntity> list = this.repository.findByFoodEntityOrderByFoodEntityAsc(entity);
        return list;
    }
}
