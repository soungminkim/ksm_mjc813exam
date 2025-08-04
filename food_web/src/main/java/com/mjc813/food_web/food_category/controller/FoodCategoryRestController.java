package com.mjc813.food_web.food_category.controller;

import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.service.FoodCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/food/category")
public class FoodCategoryRestController {
    @Autowired
    private FoodCategoryService foodCategoryService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody FoodCategoryDto dto) {
        try {
            var result = foodCategoryService.insert(dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, result));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("insert error", 20000, dto));
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> list() {
        try {
            List<FoodCategoryDto> list = foodCategoryService.findAll();
            return ResponseEntity.ok(new ResponseDto("success", 10000, list));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("list error", 20000, null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getOne(@PathVariable Long id) {
        try {
            FoodCategoryDto dto = foodCategoryService.findById(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, dto));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("get error", 20000, id));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Long id, @Validated @RequestBody FoodCategoryDto dto) {
        try {
            var result = foodCategoryService.update(id, dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, result));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("update error", 20000, dto));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        try {
            foodCategoryService.delete(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, null));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("delete error", 20000, id));
        }
    }
}