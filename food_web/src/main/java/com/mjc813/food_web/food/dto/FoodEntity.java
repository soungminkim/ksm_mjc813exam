package com.mjc813.food_web.food.dto;

import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "FoodEntity")
@Table(name = "food_tbl")
public class FoodEntity implements IFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String name;

    @Column(length = 1)
    @ColumnDefault("1")
    private Integer spicyLevel;

    @Column(length = 1)
    @ColumnDefault("1")
    private Integer sweetLevel;

    @Column(length = 1)
    @ColumnDefault("1")
    private Integer sourLevel;

    @Column(length = 1)
    @ColumnDefault("1")
    private Integer saltyLevel;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredient;

    @ManyToOne
    @JoinColumn(name = "food_category_id")
    private FoodCategoryEntity foodCategory;

    public void copyMembers(FoodDto dto) {
        this.name = dto.getName();
        this.spicyLevel = dto.getSpicyLevel();
        this.sweetLevel = dto.getSweetLevel();
        this.sourLevel = dto.getSourLevel();
        this.saltyLevel = dto.getSaltyLevel();
    }
}
