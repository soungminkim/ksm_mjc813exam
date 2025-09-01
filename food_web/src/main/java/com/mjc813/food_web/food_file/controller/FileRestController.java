package com.mjc813.food_web.food_file.controller;

import com.mjc813.food_web.common.CommonRestController;
import com.mjc813.food_web.common.ResponseCode;
import com.mjc813.food_web.common.ResponseDto;
import com.mjc813.food_web.common.dto.FileRestResponseDto;
import com.mjc813.food_web.common.exception.MyRequestException;
import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class FileRestController extends CommonRestController {
    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping(value = "/api/v1/rest/file", consumes = "multipart/form-data")
    public ResponseEntity<ResponseDto> upload(@RequestPart(name = "foodCategoryDto", required = true) FoodCategoryDto dto
            , @RequestPart(name = "fileList", required = false) List<MultipartFile> files
    ) {
        List<String> result = new ArrayList<>();
        try {
            if( dto == null ) {
                return this.getReponseEntity(ResponseCode.REQUEST_FAIL, "request fail", null, new MyRequestException("dto request error"));
            }
            log.debug("upload.FoodCategoryDto = {}", dto);
            log.debug("upload.files = {}", files.size());

            Resource resource = resourceLoader.getResource("classpath:static/images");
            String uploadDir = resource.getFile().getPath();
            for ( MultipartFile mf : files ) {
                if ( mf == null || Objects.requireNonNull(mf.getOriginalFilename()).isEmpty() ) {
                    continue;
                }
                Path copyLocation = Paths.get(uploadDir + "/" + mf.getOriginalFilename());
                Files.copy(mf.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
                result.add(mf.getOriginalFilename());
            }
        } catch (Throwable e) {
            log.error(e.toString());
        }
        FileRestResponseDto frrd = new FileRestResponseDto();
        frrd.setFoodCategoryDto(dto);
        frrd.setFiles(result);
        return this.getReponseEntity(ResponseCode.SUCCESS, "ok", frrd, null);
    }
}
