package com.mjc813.food_web.ingredient.dto;

import com.mjc813.food_web.common.IIdName;

public interface IIngredient extends IIdName {
    Long getIngredientCategoryId();
    void setIngredientCategoryId(Long ingredientCategoryId);

    IIdName getIngredientCategory();
    void setIngredientCategory(IIdName ingredientCategory);

    default void copyMembersIngredient(IIngredient source) {
        if (source == null) {
            return;
        }
        this.copyIdName(source);
        this.setIngredientCategoryId(source.getIngredientCategoryId());
        this.setIngredientCategory(source.getIngredientCategory());
    }
}