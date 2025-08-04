package com.mjc813.food_web.ingredient.controller;

import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.ingredient.dto.IngredientDto;
import com.mjc813.food_web.ingredient.service.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/ingredient")
public class IngredientRestController {
    @Autowired
    private IngredientService ingredientService;

    // 1. 등록
    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(@Validated @RequestBody IngredientDto dto) {
        try {
            var result = ingredientService.insert(dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, result));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("insert error", 20000, dto));
        }
    }

    // 2. 전체 조회
    @GetMapping("")
    public ResponseEntity<ResponseDto> list() {
        try {
            List<IngredientDto> list = ingredientService.findAll();
            return ResponseEntity.ok(new ResponseDto("success", 10000, list));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("list error", 20000, null));
        }
    }

    // 3. 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getOne(@PathVariable Long id) {
        try {
            IngredientDto dto = ingredientService.findById(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, dto));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("get error", 20000, id));
        }
    }

    // 4. 수정
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Long id, @Validated @RequestBody IngredientDto dto) {
        try {
            var result = ingredientService.update(id, dto);
            return ResponseEntity.ok(new ResponseDto("success", 10000, result));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("update error", 20000, dto));
        }
    }

    // 5. 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id) {
        try {
            ingredientService.delete(id);
            return ResponseEntity.ok(new ResponseDto("success", 10000, null));
        } catch (Throwable e) {
            log.error(e.toString());
            return ResponseEntity.ok(new ResponseDto("delete error", 20000, id));
        }
    }
}
