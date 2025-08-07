package com.mjc813.food_web.food_category.dto;

import com.mjc813.food_web.common.IIdName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "FoodCategoryEntity")
@Table(name = "food_category_tbl")
public class FoodCategoryEntity implements IIdName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
}