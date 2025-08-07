package com.mjc813.food_web.food_category.service;

import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodCategoryService {

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    @Transactional
    public FoodCategoryDto insert(FoodCategoryDto dto) {
        FoodCategoryEntity entity = FoodCategoryEntity.builder()
                .name(dto.getName())
                .build();
        FoodCategoryEntity saved = foodCategoryRepository.save(entity);
        return toDto(saved);
    }

    public List<FoodCategoryDto> findAll() {
        return foodCategoryRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public FoodCategoryDto findById(Long id) {
        FoodCategoryEntity entity = foodCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("카테고리 정보 없음: " + id));
        return toDto(entity);
    }

    @Transactional
    public FoodCategoryDto update(Long id, FoodCategoryDto dto) {
        FoodCategoryEntity entity = foodCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("수정할 카테고리 정보 없음: " + id));

        // 공용 인터페이스의 디폴트 메서드 사용
        entity.copyIdNameNotNull(dto);

        FoodCategoryEntity updated = foodCategoryRepository.save(entity);
        return toDto(updated);
    }

    @Transactional
    public void delete(Long id) {
        if (!foodCategoryRepository.existsById(id)) {
            throw new RuntimeException("이미 삭제되었거나 없는 카테고리입니다.");
        }
        foodCategoryRepository.deleteById(id);
    }

    private FoodCategoryDto toDto(FoodCategoryEntity entity) {
        return FoodCategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}