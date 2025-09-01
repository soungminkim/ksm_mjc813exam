package com.mjc813.food_web.food_ingredient.controller;

import com.mjc813.food_web.common.CommonRestController;
import com.mjc813.food_web.common.ResponseCode;
import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.food_ingredient.dto.FoodIngredientDto;
import com.mjc813.food_web.food_ingredient.dto.IFoodIngredient;
import com.mjc813.food_web.food_ingredient.service.FoodIngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/food_ingredient")
public class FoodIngredientRestController extends CommonRestController {
    @Autowired
    private FoodIngredientService foodIngredientService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(
            @Validated @RequestBody FoodIngredientDto dto
    ) {
        try {
            IFoodIngredient iFoodIngredient = this.foodIngredientService.insertRepository(dto);
//            IFoodIngredient iFoodIngredient = this.foodCategoryService.insertMybatis(dto);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iFoodIngredient, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.INSERT_FAIL, "Error", dto, th);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(
            @PathVariable Long id
            , @Validated @RequestBody FoodIngredientDto dto
    ) {
        try {
            IFoodIngredient iFoodIngredient = this.foodIngredientService.updateRepository(dto);
//            IFoodIngredient iFoodIngredient = this.foodCategoryService.updateMybatis(dto);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iFoodIngredient, null);
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
            Boolean bResult = this.foodIngredientService.deleteRepository(id);
//            Boolean bResult = this.foodCategoryService.deleteMybatis(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", bResult, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.DELETE_FAIL, "Error", id, th);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            IFoodIngredient find = this.foodIngredientService.findByIdRepository(id);
//            IFoodIngredient find = this.foodCategoryService.findByIdMybatis(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", find, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", id, th);
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll() {
        try {
            List<IFoodIngredient> all = this.foodIngredientService.findAllRepository();
//            List<IFoodIngredient> all = this.foodCategoryService.findAllMybatis();
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }

}
