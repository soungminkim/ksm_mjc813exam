package com.mjc813.food_web.food.dto;

import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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

    @Column(length = 20, nullable = false, unique = true)
    private String name;

    @ColumnDefault("1")
    private Integer spicyLevel;

    @ColumnDefault("1")
    private Integer sweetLevel;

    @ColumnDefault("1")
    private Integer sourLevel;

    @ColumnDefault("1")
    private Integer saltyLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    private FoodCategoryEntity foodCategory;
}