package com.mjc813.food_web.food.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.food_web.common.IIdName;

public interface IFood extends IIdName {
    Integer getSpicyLevel();
    void setSpicyLevel(Integer spicyLevel);

    Integer getSweetLevel();
    void setSweetLevel(Integer sweetLevel);

    Integer getSourLevel();
    void setSourLevel(Integer sourLevel);

    Integer getSaltyLevel();
    void setSaltyLevel(Integer saltyLevel);

    String getDescription();
    void setDescription(String description);


//	Long getIngredientId();
//    void setIngredientId(Long ingredientId);
//
//    @JsonIgnore
//    IIngredient getIngredient();
//    void setIngredient(IIngredient iIngredient);

    Long getFoodCategoryId();
    void setFoodCategoryId(Long foodCategoryId);

    @JsonIgnore
    IIdName getFoodCategory();
    void setFoodCategory(IIdName iIdName);

    default void copyMembersFood(IFood iFood) {
        if ( iFood == null ) {
            return;
        }
        this.copyMembersIdName(iFood);
        this.setSpicyLevel(iFood.getSpicyLevel());
        this.setSweetLevel(iFood.getSweetLevel());
        this.setSourLevel(iFood.getSourLevel());
        this.setSaltyLevel(iFood.getSaltyLevel());

//        this.setIngredient(iFood.getIngredient());
        this.setFoodCategory(iFood.getFoodCategory());
    }
}
