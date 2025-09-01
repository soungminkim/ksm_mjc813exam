package com.mjc813.food_web.ingredient.dto;

import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "IngredientEntity")
@Table(name = "ingredient_tbl")
@Builder
public class IngredientEntity implements IIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Transient
    private Long ingredientCategoryId;
    @Transient
    private String ingredientCategoryName;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ingredient_category_id", nullable = false)
    private IngredientCategoryEntity ingredientCategoryEntity;

    @Override
    public IIdName getIngredientCategory() {
        return this.ingredientCategoryEntity;
    }

    @Override
    public void setIngredientCategory(IIdName ingredientCategory) {
        if( this.ingredientCategoryEntity == null ) {
            this.ingredientCategoryEntity = new IngredientCategoryEntity();
        }
        this.ingredientCategoryEntity.copyMembersIdName(ingredientCategory);
    }

    @Override
    public Long getIngredientCategoryId() {
        // Long ingredientCategoryId 값과 IngredientCategoryEntity ingredientCategoryEntity.getId() 값이 항상 같도록 get 하는 기능
        if (this.ingredientCategoryEntity == null) {
            this.ingredientCategoryEntity = new IngredientCategoryEntity();
        }
        return this.ingredientCategoryEntity.getId();
    }

    @Override
    public void setIngredientCategoryId(Long ingredientCategoryId) {
        // Long ingredientCategoryId 값과 IngredientCategoryEntity ingredientCategoryEntity.getId() 값이 항상 같도록 set 하는 기능
        if (ingredientCategoryId == null) {
            return;
        }
        if (this.ingredientCategoryEntity == null) {
            this.ingredientCategoryEntity = new IngredientCategoryEntity();
        }
        this.ingredientCategoryEntity.setId(ingredientCategoryId);
        this.ingredientCategoryId = ingredientCategoryId;
    }
}
