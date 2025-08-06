package com.mjc813.food_web.food.controller;

import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.service.FoodService;
import com.mjc813.food_web.food_category.service.FoodCategoryService;
import com.mjc813.food_web.ingredient.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/food")
public class FoodViewController {

    @Autowired private FoodService foodService;
    @Autowired private FoodCategoryService foodCategoryService;
    @Autowired private IngredientService ingredientService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("foods", foodService.findAll());
        return "food/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("foodCategories", foodCategoryService.findAll());
        model.addAttribute("ingredients", ingredientService.findAll());
        return "food/new-form";
    }

    @PostMapping("/new")
    public String create(FoodDto dto) {
        foodService.insertFood(dto);
        return "redirect:/view/food";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("food", foodService.findById(id));
        model.addAttribute("foodCategories", foodCategoryService.findAll());
        model.addAttribute("ingredients", ingredientService.findAll());
        return "food/edit-form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, FoodDto dto) {
        foodService.update(id, dto);
        return "redirect:/view/food";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        foodService.delete(id);
        return "redirect:/view/food";
    }
}