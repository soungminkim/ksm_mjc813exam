package com.mjc813.food_web.ingredient.controller;

import com.mjc813.food_web.common.CommonRestController;
import com.mjc813.food_web.common.ResponseCode;
import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.ingredient.dto.IIngredient;
import com.mjc813.food_web.ingredient.dto.IngredientDto;
import com.mjc813.food_web.ingredient.service.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/ingredient")
public class IngredienRestController extends CommonRestController {
    @Autowired
    private IngredientService ingredientService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(
            @Validated @RequestBody IngredientDto dto
    ) {
        try {
            IIngredient iIdName = this.ingredientService.insertRepository(dto);
//            IIngredient iIdName = this.ingredientService.insertMybatis(dto);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iIdName, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.INSERT_FAIL, "Error", dto, th);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(
            @PathVariable Long id
            , @Validated @RequestBody IngredientDto dto
    ) {
        try {
            IIngredient iIdName = this.ingredientService.updateRepository(dto);
//            IIngredient iIdName = this.ingredientService.updateMybatis(dto);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iIdName, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.UPDATE_FAIL, "Error", dto, th);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(
            @PathVariable Long id
    ) {
        try {
            Boolean bResult = this.ingredientService.deleteRepository(id);
//            Boolean bResult = this.ingredientService.deleteMybatis(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", bResult, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.DELETE_FAIL, "Error", id, th);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            IIngredient find = this.ingredientService.findByIdRepository(id);
//            IIngredient find = this.ingredientService.findByIdMybatis(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", find, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", id, th);
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll() {
        try {
            List<IIngredient> all = this.ingredientService.findAllRepository();
//            List<IIngredient> all = this.ingredientService.findAllMybatis(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDto> findBySearch(
            @RequestParam("name") String name
            , @RequestParam("ingredientCategoryId") Long ingredientCategoryId
            , @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable) {
        try {
            Page<IIngredient> all = this.ingredientService.findBySearch(name, ingredientCategoryId, pageable);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }
}
