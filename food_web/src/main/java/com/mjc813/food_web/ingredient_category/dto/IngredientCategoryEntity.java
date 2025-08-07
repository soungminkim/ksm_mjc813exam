package com.mjc813.food_web.ingredient_category.dto;

import com.mjc813.food_web.common.IIdName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "IngredientCategoryEntity")
@Table(name = "ingredient_category_tbl")
public class IngredientCategoryEntity implements IIdName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
}