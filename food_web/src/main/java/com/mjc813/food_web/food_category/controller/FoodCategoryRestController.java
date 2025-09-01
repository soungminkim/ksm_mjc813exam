package com.mjc813.food_web.food_category.controller;

import com.mjc813.food_web.common.CommonRestController;
import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.common.ResponseCode;
import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import com.mjc813.food_web.food_category.service.FoodCategoryService;
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
@RequestMapping("/api/v1/food_category")
public class FoodCategoryRestController extends CommonRestController {
    @Autowired
    private FoodCategoryService foodCategoryService;

    @PostMapping("")
    public ResponseEntity<ResponseDto> insert(
            @Validated @RequestBody FoodCategoryDto dto
    ) {
        try {
            IIdName iIdName = this.foodCategoryService.insertRepository(dto);
//            IIdName iIdName = this.foodCategoryService.insertMybatis(dto);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", iIdName, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.INSERT_FAIL, "Error", dto, th);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto> update(
            @PathVariable Long id
            , @Validated @RequestBody FoodCategoryDto dto
    ) {
        try {
            IIdName iIdName = this.foodCategoryService.updateRepository(dto);
//            IIdName iIdName = this.foodCategoryService.updateMybatis(dto);
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
            Boolean bResult = this.foodCategoryService.deleteRepository(id);
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
            IIdName find = this.foodCategoryService.findByIdRepository(id);
//            IIdName find = this.foodCategoryService.findByIdMybatis(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", find, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", id, th);
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseDto> findAll() {
        try {
            List<IIdName> all = this.foodCategoryService.findAllRepository();
//            List<IIdName> all = this.foodCategoryService.findAllMybatis(id);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDto> findBySearch(
            @RequestParam("name") String name
            , @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable) {
        try {
            Page<FoodCategoryEntity> all = this.foodCategoryService.findByNameContainsRepository(name, pageable);
//            Page<FoodCategoryDto> all = this.foodCategoryService.findByNameContainsMybatis(name, pageable);
            return this.getReponseEntity(ResponseCode.SUCCESS, "OK", all, null);
        } catch (Throwable th) {
            log.error(th.toString());
            return this.getReponseEntity(ResponseCode.SELECT_FAIL, "Error", null, th);
        }
    }
}
