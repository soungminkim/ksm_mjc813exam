package com.mjc813.food_web.food_category.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
public class FoodCategoryEntity {
}
