package com.mjc813.food_web.food.service;

import com.mjc813.food_web.common.exception.MyDataNotFoundException;
import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food.dto.FoodIngsResponseDto;
import com.mjc813.food_web.food.dto.IFood;
import com.mjc813.food_web.food_file.service.FoodFileRepository;
import com.mjc813.food_web.food_ingredient.dto.FoodIngredientDto;
import com.mjc813.food_web.food_ingredient.dto.FoodIngredientEntity;
import com.mjc813.food_web.food_ingredient.service.FoodIngredientRepository;
import jakarta.transaction.Transactional;
import org.hibernate.collection.spi.PersistentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodJpaTransactionService {
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodIngredientRepository foodIngredientRepository;

    @Autowired
    private FoodFileRepository foodFileRepository;

    @Transactional
    public void insert(FoodDto foodDto, List<FoodIngredientDto> ingredientDtoList) {
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.copyMembersFood(foodDto);
        this.foodRepository.save(foodEntity);

        List<FoodIngredientEntity> ingredientEntityList = new ArrayList<>();
        for( FoodIngredientDto dto : ingredientDtoList ) {
            FoodIngredientEntity foodIngredientEntity =  new FoodIngredientEntity();
            foodIngredientEntity.copyMembersFoodIngredient(dto);
            foodIngredientEntity.setFoodId(foodEntity.getId());
            ingredientEntityList.add(foodIngredientEntity);
        }
        this.foodIngredientRepository.saveAll(ingredientEntityList);
    }

    @Transactional
    public void update(FoodDto foodDto, List<FoodIngredientDto> ingredientDtoList) {
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.copyMembersFood(foodDto);
        this.foodRepository.save(foodEntity);

        this.foodIngredientRepository.deleteAllByFoodEntity(foodEntity);
        List<FoodIngredientEntity> ingredientEntityList = new ArrayList<>();
        for( FoodIngredientDto dto : ingredientDtoList ) {
            FoodIngredientEntity foodIngredientEntity =  new FoodIngredientEntity();
            foodIngredientEntity.copyMembersFoodIngredient(dto);
            foodIngredientEntity.setFoodId(foodEntity.getId());
            ingredientEntityList.add(foodIngredientEntity);
        }
        this.foodIngredientRepository.saveAll(ingredientEntityList);
    }

    @Transactional
    public void delete(Long foodId) {
        FoodEntity foodEntity = FoodEntity.builder().id(foodId).build();
        this.foodIngredientRepository.deleteAllByFoodEntity(foodEntity);
        this.foodRepository.deleteById(foodId);
    }

    public FoodIngsResponseDto getFoodAndIngredientList(Long id) throws Exception {
        Optional<FoodEntity> find = this.foodRepository.findById(id);
        if ( find.isEmpty() ) {
            throw new MyDataNotFoundException("id can't found !");
        }
        FoodDto findDto = new FoodDto();
        findDto.copyMembersFood(find.get());

        List<FoodIngredientDto> list = new ArrayList<>();
        List<FoodIngredientEntity> findList = this.foodIngredientRepository.findByFoodEntityOrderByFoodEntityAsc(find.get());
        for( FoodIngredientEntity entity : findList ) {
            FoodIngredientDto dto = new FoodIngredientDto();
            dto.copyMembersFoodIngredient(entity);
            list.add(dto);
        }

        FoodIngsResponseDto result = FoodIngsResponseDto.builder()
                .food(findDto)
                .foodIngs(list)
                .build();
        return result;
    }

    public List<FoodIngsResponseDto> getFoodsAndIngredientList() throws Exception {
        List<FoodEntity> list = this.foodRepository.findAll();
        List<FoodIngsResponseDto> result = new ArrayList<>();
        for ( FoodEntity entity : list ) {
            FoodIngsResponseDto item = this.getFoodAndIngredientList(entity.getId());
            result.add(item);
        }
        return result;
    }
}
