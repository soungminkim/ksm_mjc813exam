package com.mjc813.food_web.ingredient.dto;

import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "IngredientEntity")
@Table(name = "ingredient_tbl")
public class IngredientEntity implements IIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_category_id")
    private IngredientCategoryEntity ingredientCategory;

    @Override
    public Long getIngredientCategoryId() {
        return ingredientCategory != null ? ingredientCategory.getId() : null;
    }

    @Override
    public void setIngredientCategoryId(Long ingredientCategoryId) {
        // This is handled by setting the ingredientCategory entity
    }

    @Override
    public void setIngredientCategory(IIdName ingredientCategory) {
        if (ingredientCategory instanceof IngredientCategoryEntity) {
            this.ingredientCategory = (IngredientCategoryEntity) ingredientCategory;
        }
    }
}