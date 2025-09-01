package com.mjc813.food_web.food.service;

import com.mjc813.food_web.food.dto.FoodDetailDto;
import com.mjc813.food_web.food.dto.FoodDto;
import com.mjc813.food_web.food.dto.FoodEntity;
import com.mjc813.food_web.food.dto.IFood;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodMapper mapper;

    @Autowired
    private FoodRepository repository;

    public IFood insertRepository(FoodDto dto) {
        FoodEntity entity = new FoodEntity();
        entity.copyMembersFood(dto);
        FoodEntity result = this.repository.save(entity);
        return result;
    }

    public IFood insertMybatis(FoodDto dto) {
        this.mapper.insert(dto);
        return dto;
    }

    public IFood updateRepository(FoodDto dto) {
        return this.insertRepository(dto);
    }

    public IFood updateMybatis(FoodDto dto) {
        this.mapper.update(dto);
        return dto;
    }

    public Boolean deleteRepository(Long id) {
        this.repository.deleteById(id);
        return true;
    }

    public Boolean deleteMybatis(Long id) {
        this.mapper.delete(id);
        return true;
    }

    public IFood findByIdRepository(Long id) throws Exception {
        Optional<FoodEntity> find = this.repository.findById(id);
        if ( find.isPresent() ) {
            return find.get();
        } else {
            throw new NotFoundException(String.format("data cat not found [%d]", id));
        }
    }

    public IFood findByIdMybatis(Long id) throws Exception {
        FoodDto find = this.mapper.findById(id);
        if ( find != null ) {
            return find;
        } else {
            throw new NotFoundException(String.format("data cat not found [%d]", id));
        }
    }

    public List<IFood> findAllRepository() {
        List<FoodEntity> all = this.repository.findAllByOrderByIdDesc();
        List<IFood> result = all.parallelStream()
                .map(x -> (IFood)x).toList();
        return result;
    }

    public List<FoodDetailDto> findAllMybatis() {
        List<FoodDetailDto> all = this.mapper.findAll();
//        List<IFood> result = all.parallelStream()
//                .map(x -> (IFood)x).toList();
        return all;
    }

    public Page<FoodDetailDto> findBySearch(String name, Long foodCategoryId, Pageable pageable) {
        List<FoodDetailDto> list = this.mapper.findBySearch(name, foodCategoryId, pageable);
        Long count = this.mapper.countBySearch(name, foodCategoryId);
        return new PageImpl<>(list, pageable, count);
    }
}
