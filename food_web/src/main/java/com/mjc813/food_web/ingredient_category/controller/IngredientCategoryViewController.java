package com.mjc813.food_web.ingredient_category.controller;

import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import com.mjc813.food_web.ingredient_category.service.IngredientCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/ingredient-category")
public class IngredientCategoryViewController {

    @Autowired
    private IngredientCategoryService ingredientCategoryService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("categories", ingredientCategoryService.findAll());
        return "ingredient-category/list";
    }

    @GetMapping("/new")
    public String newForm() {
        return "ingredient-category/new-form";
    }

    @PostMapping("/new")
    public String create(IngredientCategoryDto dto) {
        ingredientCategoryService.insert(dto);
        return "redirect:/view/ingredient-category";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("category", ingredientCategoryService.findById(id));
        return "ingredient-category/edit-form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, IngredientCategoryDto dto) {
        ingredientCategoryService.update(id, dto);
        return "redirect:/view/ingredient-category";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        ingredientCategoryService.delete(id);
        return "redirect:/view/ingredient-category";
    }
}