package com.mjc813.food_web.ingredient.controller;

import com.mjc813.food_web.ingredient.dto.IngredientDto;
import com.mjc813.food_web.ingredient.service.IngredientService;
import com.mjc813.food_web.ingredient_category.service.IngredientCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/ingredient")
public class IngredientViewController {

    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private IngredientCategoryService ingredientCategoryService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("ingredients", ingredientService.findAll());
        return "ingredient/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("categories", ingredientCategoryService.findAll());
        return "ingredient/new-form";
    }

    @PostMapping("/new")
    public String create(IngredientDto dto) {
        ingredientService.insert(dto);
        return "redirect:/view/ingredient";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("ingredient", ingredientService.findById(id));
        model.addAttribute("categories", ingredientCategoryService.findAll());
        return "ingredient/edit-form";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, IngredientDto dto) {
        ingredientService.update(id, dto);
        return "redirect:/view/ingredient";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        ingredientService.delete(id);
        return "redirect:/view/ingredient";
    }
}