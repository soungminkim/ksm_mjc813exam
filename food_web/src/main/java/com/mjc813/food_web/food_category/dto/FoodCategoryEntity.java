package com.mjc813.food_web.food_category.dto;

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
@Entity(name = "FoodCategoryEntity")
@Table(name = "food_category_tbl")
public class FoodCategoryEntity implements IIdName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;
}
