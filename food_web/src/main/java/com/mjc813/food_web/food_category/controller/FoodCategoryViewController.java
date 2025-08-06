package com.mjc813.food_web.food_category.controller;

import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.service.FoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/food-category")
public class FoodCategoryViewController {

    @Autowired
    private FoodCategoryService foodCategoryService;

    // 1. 목록 페이지
    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("categories", foodCategoryService.findAll());
        return "food-category/list";
    }

    // 2. 등록 페이지로 이동
    @GetMapping("/new")
    public String newForm() {
        return "food-category/new-form";
    }

    // 3. 등록 처리
    @PostMapping("/new")
    public String create(FoodCategoryDto dto) {
        foodCategoryService.insert(dto);
        return "redirect:/view/food-category";
    }

    // 4. 수정 페이지로 이동
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        FoodCategoryDto dto = foodCategoryService.findById(id);
        model.addAttribute("category", dto);
        return "food-category/edit-form";
    }

    // 5. 수정 처리
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Long id, FoodCategoryDto dto) {
        foodCategoryService.update(id, dto);
        return "redirect:/view/food-category";
    }

    // 6. 삭제 처리
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        foodCategoryService.delete(id);
        return "redirect:/view/food-category";
    }
}