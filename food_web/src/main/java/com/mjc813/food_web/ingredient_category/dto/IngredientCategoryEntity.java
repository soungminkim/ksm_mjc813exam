package com.mjc813.food_web.ingredient_category.dto;

import com.mjc813.food_web.common.IIdName;
import jakarta.persistence.*;
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
public class IngredientCategoryEntity implements IIdName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;
}
