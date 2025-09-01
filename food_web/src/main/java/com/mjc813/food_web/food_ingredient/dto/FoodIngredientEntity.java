package com.mjc813.food_web.food_ingredient.dto;

import com.mjc813.food_web.common.EIngredientUnit;
import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food.dto.IFood;
import com.mjc813.food_web.ingredient.dto.IIngredient;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "FoodIngredientEntity")
@Table(name = "food_ingredient_tbl")
public class FoodIngredientEntity implements IFoodIngredient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Long foodId;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private FoodEntity foodEntity;

    @Transient
    private Long ingredientId;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ingredient_id", nullable = false)
    private IngredientEntity ingredientEntity;

    private EIngredientUnit unit;

    private BigDecimal capacity;

    @Override
    public Long getFoodId() {
        if ( this.foodEntity == null ) {
            this.foodEntity = new FoodEntity();
        }
        return this.foodEntity.getId();
    }

    @Override
    public void setFoodId(Long foodId) {
        if ( this.foodEntity == null ) {
            this.foodEntity = new FoodEntity();
        }
        this.foodEntity.setId(foodId);
        this.foodId = foodId;
    }

    @Override
    public IFood getFood() {
        return this.foodEntity;
    }

    @Override
    public void setFood(IFood iFood) {
        if ( iFood == null ) {
            return;
        }
        if ( this.foodEntity == null ) {
            this.foodEntity = new FoodEntity();
        }
        this.foodEntity.copyMembersFood(iFood);
    }

    @Override
    public Long getIngredientId() {
        if ( this.ingredientEntity == null ) {
            this.ingredientEntity = new IngredientEntity();
        }
        return this.ingredientEntity.getId();
    }

    @Override
    public void setIngredientId(Long ingredientId) {
        if ( this.ingredientEntity == null ) {
            this.ingredientEntity = new IngredientEntity();
        }
        this.ingredientEntity.setId(ingredientId);
        this.ingredientId = ingredientId;
    }

    @Override
    public IIngredient getIngredient() {
        return this.ingredientEntity;
    }

    @Override
    public void setIngredient(IIngredient iIngredient) {
        if ( iIngredient == null ) {
            return;
        }
        if ( this.ingredientEntity == null ) {
            this.ingredientEntity = new IngredientEntity();
        }
        this.ingredientEntity.copyMembersIngredient(iIngredient);
    }
}
