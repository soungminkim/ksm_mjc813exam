package com.mjc813.food_web.food.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDto implements IFood {
    private Long id;

    @Size(min=3, max=40)
    private String name;

    @Min(0)
    @Max(10)
    private Integer spicyLevel;

    @Min(0)
    @Max(10)
    private Integer sweetLevel;

    @Min(0)
    @Max(10)
    private Integer sourLevel;

    @Min(0)
    @Max(10)
    private Integer saltyLevel;

    @Max(65000)
    private String description;


    private Long foodCategoryId;

    @JsonIgnore
    private FoodCategoryDto foodCategoryDto;    // Dto 는 객체를 사용하지 않습니다. IFood 인터페이스 때문에 등장

//    @Override
//    public IIngredient getIngredient() {
//        return this.ingredientDto;
//    }
//
//    @Override
//    public void setIngredient(IIngredient iIngredient) {
//        if ( iIngredient == null ) {
//            return;
//        }
//        if ( this.ingredientDto == null ) {
//            this.ingredientDto = new IngredientDto();
//        }
//        this.ingredientDto.copyMembersIngredient(iIngredient);
//    }
//
//    @Override
//    public Long getIngredientId() {
//        // Long ingredientId 값과 IngredientDto ingredientDto.getId() 값이 항상 같도록 get 하는 기능
////        this.setIngredientId(this.ingredientId);
//        if ( this.ingredientDto != null ) {
//            return this.ingredientDto.getId();
//        }
//        return this.ingredientId;
//    }
//
//    @Override
//    public void setIngredientId(Long ingredientId) {
//        // Long ingredientId 값과 IngredientDto ingredientDto.getId() 값이 항상 같도록 set 하는 기능
//        if (ingredientId == null) {
//            if (this.ingredientDto != null && this.ingredientDto.getId() != null) {
//                this.ingredientId = this.ingredientDto.getId();
//            }
//            return;
//        }
//        this.ingredientId = ingredientId;
//        if (this.ingredientDto == null) {
//            this.ingredientDto = new IngredientDto();
//        }
//        this.ingredientDto.setId(ingredientId);
//    }

    @Override
    public IIdName getFoodCategory() {
        return this.foodCategoryDto;
    }

    @Override
    public void setFoodCategory(IIdName iIdName) {
        if ( iIdName == null ) {
            return;
        }
        if ( this.foodCategoryDto == null ) {
            this.foodCategoryDto = new FoodCategoryDto();
        }
        this.foodCategoryDto.copyMembersIdName(iIdName);
    }

    @Override
    public Long getFoodCategoryId() {
        // Long foodCategoryId 값과 FoodCategoryDto foodCategoryDto.getId() 값이 항상 같도록 get 하는 기능
//        this.setFoodCategoryId(this.foodCategoryId);
        if ( this.foodCategoryDto != null ) {
            return this.foodCategoryDto.getId();
        }
        return this.foodCategoryId;
    }

    @Override
    public void setFoodCategoryId(Long foodCategoryId) {
        // Long foodCategoryId 값과 FoodCategoryDto foodCategoryDto.getId() 값이 항상 같도록 set 하는 기능
        if (foodCategoryId == null) {
            if (this.foodCategoryDto != null && this.foodCategoryDto.getId() != null) {
                this.foodCategoryId = this.foodCategoryDto.getId();
            }
            return;
        }
        this.foodCategoryId = foodCategoryId;
        if (this.foodCategoryDto == null) {
            this.foodCategoryDto = new FoodCategoryDto();
        }
        this.foodCategoryDto.setId(foodCategoryId);
    }
}
