package com.mjc813.food_web.ingredient_category.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "IngredientCategoryEntity")
@Table(name = "ingredient_category_tbl")
public class IngredientCategoryEntity {
}
