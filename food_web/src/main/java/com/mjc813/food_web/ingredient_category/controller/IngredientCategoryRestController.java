package com.mjc813.food_web.ingredient_category.controller;

import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import com.mjc813.food_web.ingredient_category.service.IngredientCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ingredient/category")
public class IngredientCategoryRestController {
    @Autowired
    private IngredientCategoryService ingredientCategoryService;

    // 등록(Create)
    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody IngredientCategoryDto dto) {
        try {
            var result = ingredientCategoryService.insert(dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, result));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("insert error", 20000, dto));
        }
    }

    // 전체조회(Read)
    @GetMapping("")
    public ResponseEntity<ResponseDto> list() {
        try {
            List<IngredientCategoryDto> list = ingredientCategoryService.findAll();
            return ResponseEntity.ok(new ResponseDto("success", 10000, list));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("list error", 20000, null));
        }
    }

    // 단일조회(Read)
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getOne(@PathVariable Long id) {
        try {
            IngredientCategoryDto dto = ingredientCategoryService.findById(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, dto));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("get error", 20000, id));
        }
    }

    // 수정(Update)
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Long id, @Validated @RequestBody IngredientCategoryDto dto) {
        try {
            var result = ingredientCategoryService.update(id, dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, result));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("update error", 20000, dto));
        }
    }

    // 삭제(Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        try {
            ingredientCategoryService.delete(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, null));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("delete error", 20000, id));
        }
    }
}
