package com.mjc813.food_web.ingredient.dto;

public interface IIngredient {
    public Long getId();
    public String getName();
    public Long getIngredientCategoryId();

    public void setId(final Long id);
    public void setName(final String name);
    public void setIngredientCategoryId(final Long ingredientCategoryId);

    default void copyMembers(IIngredient from) {
        setId(from.getId());
        setName(from.getName());
        setIngredientCategoryId(from.getIngredientCategoryId());
    }
}
