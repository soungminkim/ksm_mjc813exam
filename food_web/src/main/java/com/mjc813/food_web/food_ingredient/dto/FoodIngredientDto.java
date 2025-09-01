package com.mjc813.food_web.food_ingredient.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.food_web.common.EIngredientUnit;
import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.dto.IFood;
import com.mjc813.food_web.ingredient.dto.IIngredient;
import com.mjc813.food_web.ingredient.dto.IngredientDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodIngredientDto implements IFoodIngredient {
    private Long id;

    private Long foodId;
    private FoodDto foodDto;

    private Long ingredientId;

//    @JsonIgnore
    private IngredientDto ingredientDto;

    @NotEmpty
    private EIngredientUnit unit;

    @Min(0)
    private BigDecimal capacity;

    @Override
    public Long getFoodId() {
        if ( this.foodDto == null ) {
            this.foodDto = new FoodDto();
        }
        return this.foodDto.getId();
    }

    @Override
    public void setFoodId(Long foodId) {
        if ( this.foodDto == null ) {
            this.foodDto = new FoodDto();
        }
        this.foodDto.setId(foodId);
        this.foodId = foodId;
    }

    @JsonIgnore
    @Override
    public IFood getFood() {
        return this.foodDto;
    }

    @Override
    public void setFood(IFood iFood) {
        if ( iFood == null ) {
            return;
        }
        if ( this.foodDto == null ) {
            this.foodDto = new FoodDto();
        }
        this.foodDto.copyMembersFood(iFood);
    }

    @Override
    public Long getIngredientId() {
        if ( this.ingredientDto == null ) {
            this.ingredientDto = new IngredientDto();
        }
        return this.ingredientDto.getId();
    }

    @Override
    public void setIngredientId(Long ingredientId) {
        if ( this.ingredientDto == null ) {
            this.ingredientDto = new IngredientDto();
        }
        this.ingredientDto.setId(ingredientId);
        this.ingredientId = ingredientId;
    }

    @JsonIgnore
    @Override
    public IIngredient getIngredient() {
        return this.ingredientDto;
    }

    @Override
    public void setIngredient(IIngredient iIngredient) {
        if ( iIngredient == null ) {
            return;
        }
        if ( this.ingredientDto == null ) {
            this.ingredientDto = new IngredientDto();
        }
        this.ingredientDto.copyMembersIngredient(iIngredient);
    }
}
