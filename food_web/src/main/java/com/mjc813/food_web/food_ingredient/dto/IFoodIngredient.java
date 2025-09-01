package com.mjc813.food_web.food_ingredient.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.food_web.common.EIngredientUnit;
import com.mjc813.food_web.food.dto.IFood;
import com.mjc813.food_web.ingredient.dto.IIngredient;

import java.math.BigDecimal;

public interface IFoodIngredient {
    Long getId();
    void setId(Long id);

    Long getFoodId();
    void setFoodId(Long id);

    EIngredientUnit getUnit();
    void setUnit(EIngredientUnit unit);

    BigDecimal getCapacity();
    void setCapacity(BigDecimal capacity);

    @JsonIgnore
    IFood getFood();
    void setFood(IFood iFood);

    Long getIngredientId();
    void setIngredientId(Long ingredientId);

    @JsonIgnore
    IIngredient getIngredient();
    void setIngredient(IIngredient iIngredient);

    default void copyMembersFoodIngredient(IFoodIngredient iFoodIngredient) {
        this.setId(iFoodIngredient.getId());
        this.setFoodId(iFoodIngredient.getFoodId());
        this.setIngredientId(iFoodIngredient.getIngredientId());
        this.setFood(iFoodIngredient.getFood());
        this.setIngredient(iFoodIngredient.getIngredient());
        this.setCapacity(iFoodIngredient.getCapacity());
        this.setUnit(iFoodIngredient.getUnit());
    }
}
