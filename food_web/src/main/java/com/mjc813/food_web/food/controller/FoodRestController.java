package com.mjc813.food_web.food.controller;

import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.dto.IFood;
import com.mjc813.food_web.food.service.FoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        } catch (Throwable e){
            log.error(e.toString());
            return ResponseEntity.ok().body(
                new ResponseDto("insert error", 20000, dto)
            );
        }
    }
}
