package com.mjc813.food_web.food.controller;

import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.dto.IFood;
import com.mjc813.food_web.food.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/food")
public class FoodRestController {
    @Autowired
    private FoodService foodService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insertFood(@Validated @RequestBody FoodDto dto) {
        try {
            IFood result = this.foodService.insertFood(dto);
            return ResponseEntity.ok().body(
                    new ResponseDto("success", 10000, result)
            );
        } catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.ok().body(
                new ResponseDto("insert error", 20000, dto)
            );
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> list() {
        try {
            var list = foodService.findAll();
            return ResponseEntity.ok().body(
                    new ResponseDto("success", 10000, list)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    new ResponseDto("list error", 20000, null)
            );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getOne(@PathVariable Long id) {
        try {
            var food = foodService.findById(id);
            return ResponseEntity.ok().body(
                    new ResponseDto("success", 10000, food)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    new ResponseDto("get error", 20000, id)
            );
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Long id, @Validated @RequestBody FoodDto dto) {
        try {
            var result = foodService.update(id, dto);
            return ResponseEntity.ok().body(
                    new ResponseDto("success", 10000, result)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    new ResponseDto("update error", 20000, dto)
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        try {
            foodService.delete(id);
            return ResponseEntity.ok().body(
                    new ResponseDto("success", 10000, null)
            );
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok().body(
                    new ResponseDto("delete error", 20000, id)
            );
        }
    }
}
