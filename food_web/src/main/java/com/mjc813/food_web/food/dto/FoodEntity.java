package com.mjc813.food_web.food.dto;

import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "FoodEntity")
@Table(name = "food_tbl")
public class FoodEntity implements IFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    private Integer spicyLevel;
    private Integer sweetLevel;
    private Integer sourLevel;
    private Integer saltyLevel;

    @Column(length = 65500)
    private String description;


//    @Transient
//    private Long ingredientId;  // @Entity 는 Long 형의 외래키 id 를 사용하지 않습니다. IFood 이라는 인터페이스 때문에 등장

////    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "ingredient_id")
//    private IngredientEntity ingredientEntity;

    @Transient
    private Long foodCategoryId;    //  @Entity 는 Long 형의 외래키 id 를 사용하지 않습니다. IFood 이라는 인터페이스 때문에 등장

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "food_category_id")
    private FoodCategoryEntity foodCategoryEntity;

//    @Override
//    public Long getIngredientId() {
//        // Long ingredientId 값과 IngredientEntity ingredientEntity.getId() 값이 항상 같도록 get 하는 기능
//        if (this.ingredientEntity == null) {
//            this.ingredientEntity = new IngredientEntity();
//        }
//        return this.ingredientEntity.getId();
//    }
//
//    @Override
//    public void setIngredientId(Long ingredientId) {
//        // Long ingredientId 값과 IngredientEntity ingredientEntity.getId() 값이 항상 같도록 set 하는 기능
//        if (ingredientId == null) {
//            return;
//        }
//        if (this.ingredientEntity == null) {
//            this.ingredientEntity = new IngredientEntity();
//        }
//        this.ingredientEntity.setId(ingredientId);
//        this.ingredientId = ingredientId;
//    }
//
//
//    @Override
//    public IIngredient getIngredient() {
//        return this.ingredientEntity;
//    }
//
//    @Override
//    public void setIngredient(IIngredient iIngredient) {
//        if ( iIngredient == null ) {
//            return;
//        }
//        if ( this.ingredientEntity == null ) {
//            this.ingredientEntity = new IngredientEntity();
//        }
//        this.ingredientEntity.copyMembersIngredient(iIngredient);
//    }

    @Override
    public IIdName getFoodCategory() {
        return this.foodCategoryEntity;
    }

    @Override
    public void setFoodCategory(IIdName iIdName) {
        if ( iIdName == null ) {
            return;
        }
        if ( this.foodCategoryEntity == null ) {
            this.foodCategoryEntity = new FoodCategoryEntity();
        }
        this.foodCategoryEntity.copyMembersIdName(iIdName);
    }

    @Override
    public Long getFoodCategoryId() {
        // Long foodCategoryId 값과 FoodCategoryEntity foodCategoryEntity.getId() 값이 항상 같도록 get 하는 기능
        if (this.foodCategoryEntity == null) {
            this.foodCategoryEntity = new FoodCategoryEntity();
        }
        return this.foodCategoryEntity.getId();
    }

    @Override
    public void setFoodCategoryId(Long foodCategoryId) {
        // Long foodCategoryId 값과 FoodCategoryEntity foodCategoryEntity.getId() 값이 항상 같도록 set 하는 기능
        if (foodCategoryId == null) {
            return;
        }
        if (this.foodCategoryEntity == null) {
            this.foodCategoryEntity = new FoodCategoryEntity();
        }
        this.foodCategoryEntity.setId(foodCategoryId);
        this.foodCategoryId = foodCategoryId;
    }
}
