package com.mjc813.food_web.food.controller;

import com.mjc813.food_web.common.CommonRestController;
import com.mjc813.food_web.common.ResponseCode;
import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.food.dto.*;
import com.mjc813.food_web.food.service.FoodJpaTransactionService;
import com.mjc813.food_web.food.service.FoodService;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.food_ingredient.dto.FoodIngredientDto;
import com.mjc813.food_web.food_ingredient.dto.FoodIngredientEntity;
import com.mjc813.food_web.food_ingredient.service.FoodIngredientService;
import com.mjc813.food_web.ingredient.dto.IngredientDto;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/food")
public class FoodRestController extends CommonRestController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodJpaTransactionService foodJpaTransactionService;

    @Autowired
    private FoodIngredientService foodIngredientService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(
            @Validated @RequestBody FoodDto dto
    ) {
        try {
            IFood iIdName = this.foodService.insertRepository(dto);
//            IFood iIdName = this.foodService.insertMybatis(dto);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iIdName, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.INSERT_FAIL, "Error", dto, th);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(
            @PathVariable Long id
            , @Validated @RequestBody FoodDto dto
    ) {
        try {
            IFood iIdName = this.foodService.updateRepository(dto);
//            IFood iIdName = this.foodService.updateMybatis(dto);
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
//            Boolean bResult = this.foodService.deleteRepository(id);
//            Boolean bResult = this.foodService.deleteMybatis(id);
            this.foodJpaTransactionService.delete(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", true, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.DELETE_FAIL, "Error", id, th);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable Long id) {
        try {
            FoodIngsResponseDto result = this.foodJpaTransactionService.getFoodAndIngredientList(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", result, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", id, th);
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll() {
        try {
            List<FoodIngsResponseDto> all = this.foodJpaTransactionService.getFoodsAndIngredientList();
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDto> findBySearch(
            @RequestParam("name") String name
            , @RequestParam("foodCategoryId") Long foodCategoryId
            , @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable) {
        try {
            Page<FoodDetailDto> all = this.foodService.findBySearch(name, foodCategoryId, pageable);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }

    @PostMapping("/ings")
    public ResponseEntity<ResponseDto> insertFoodIngs(
            @Validated @RequestPart(value = "foodAndIngs", required = true) FoodIngsRequestDto foodIngs
            , @RequestPart(value = "fileList", required = false) List<MultipartFile> fileList
    ) {
        try {
            this.foodJpaTransactionService.insert(foodIngs.getFood(), foodIngs.getFoodIngs(), fileList);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", foodIngs, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.INSERT_FAIL, "Error", foodIngs, th);
        }
    }

    @PatchMapping("/ings/{id}")
    public ResponseEntity<ResponseDto> updateFoodIngs(
            @Validated @PathVariable Long id
            , @Validated @RequestBody FoodIngsRequestDto foodIngs
    ) {
        try {
            this.foodJpaTransactionService.update(foodIngs.getFood(), foodIngs.getFoodIngs());
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", foodIngs, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.INSERT_FAIL, "Error", foodIngs, th);
        }
    }

    @GetMapping("/ingsr")
    public ResponseEntity<ResponseDto> getIngs() {
        try {
            FoodDto fd = FoodDto.builder().id(123L).name("1234").saltyLevel(1)
                    .sourLevel(2).spicyLevel(3).sweetLevel(4)
                    .foodCategoryId(1L)
                    .build();
            FoodIngsRequestDto fird = new FoodIngsRequestDto();
            fird.setFood(fd);
            List<FoodIngredientDto> list = new ArrayList<>();
            IngredientCategoryDto icd1 = IngredientCategoryDto.builder().id(3L).name("abc").build();
            IngredientCategoryDto icd2 = IngredientCategoryDto.builder().id(6L).name("deg").build();
            IngredientDto ing1 = IngredientDto.builder().id(10L).name("101010").ingredientCategoryId(icd1.getId()).build();
            IngredientDto ing2 = IngredientDto.builder().id(20L).name("202020").ingredientCategoryId(icd2.getId()).build();
            IngredientDto ing3 = IngredientDto.builder().id(30L).name("303030").ingredientCategoryId(icd1.getId()).build();
            list.add(FoodIngredientDto.builder().foodDto(fd).ingredientDto(ing1).build());
            list.add(FoodIngredientDto.builder().foodDto(fd).ingredientDto(ing2).build());
            list.add(FoodIngredientDto.builder().foodDto(fd).ingredientDto(ing3).build());
            fird.setFoodIngs(list);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", fird, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.INSERT_FAIL, "Error", null, th);
        }
    }
}
