package com.mjc813.food_web.ingredient.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.food_web.common.IIdName;

public interface IIngredient extends IIdName {
    Long getIngredientCategoryId();
    void setIngredientCategoryId(Long ingredientCategoryId);

    String getIngredientCategoryName();
    void setIngredientCategoryName(String ingredientCategoryName);

    @JsonIgnore
    IIdName getIngredientCategory();
    void setIngredientCategory(IIdName ingredientCategory);

    default void copyMembersIngredient(IIngredient iIngredient) {
        if ( iIngredient == null) {
            return;
        }
        this.copyMembersIdName(iIngredient);
        this.setIngredientCategoryId(iIngredient.getIngredientCategoryId());
        this.setIngredientCategoryName(iIngredient.getIngredientCategoryName());
        this.setIngredientCategory(iIngredient.getIngredientCategory());
    }

    default void copyMembersIngredientNotNull(IIngredient iIngredient) {
        if ( iIngredient == null) {
            return;
        }
        iIngredient.copyMembersIdName(iIngredient);
        if ( iIngredient.getIngredientCategoryId() != null) {
            this.setIngredientCategoryId(iIngredient.getIngredientCategoryId());
        }
        if ( iIngredient.getIngredientCategory() != null) {
            this.setIngredientCategory(iIngredient.getIngredientCategory());
        }
    }
}
