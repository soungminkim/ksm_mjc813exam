package com.mjc813.food_web.food_category.service;

import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.food_category.dto.FoodCategoryDto;
import com.mjc813.food_web.food_category.dto.FoodCategoryEntity;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodCategoryService {
    @Autowired
    private FoodCategoryMapper mapper;

    @Autowired
    private FoodCategoryRepository repository;

    public IIdName insertRepository(FoodCategoryDto dto) {
        FoodCategoryEntity entity = new FoodCategoryEntity();
        entity.copyMembersIdName(dto);
        FoodCategoryEntity result = this.repository.save(entity);
        return result;
    }

    public IIdName insertMybatis(FoodCategoryDto dto) {
        this.mapper.insert(dto);
        return dto;
    }

    public IIdName updateRepository(FoodCategoryDto dto) {
        return this.insertRepository(dto);
    }

    public IIdName updateMybatis(FoodCategoryDto dto) {
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

    public IIdName findByIdRepository(Long id) throws Exception {
        Optional<FoodCategoryEntity> find = this.repository.findById(id);
        if ( find.isPresent() ) {
            return find.get();
        } else {
            throw new NotFoundException(String.format("data cat not found [%d]", id));
        }
    }

    public IIdName findByIdMybatis(Long id) throws Exception {
        FoodCategoryDto find = this.mapper.findById(id);
        if ( find != null ) {
            return find;
        } else {
            throw new NotFoundException(String.format("data cat not found [%d]", id));
        }
    }

    public List<IIdName> findAllRepository() {
        List<FoodCategoryEntity> all = this.repository.findAllByOrderByIdDesc();
        List<IIdName> result = all.parallelStream()
                .map(x -> (IIdName)x).toList();
        return result;
    }

    public List<IIdName> findAllMybatis() {
        List<FoodCategoryDto> all = this.mapper.findAll();
        List<IIdName> result = all.parallelStream()
                .map(x -> (IIdName)x).toList();
        return result;
    }

    public Page<FoodCategoryEntity> findByNameContainsRepository(String name, Pageable pageable) {
        Page<FoodCategoryEntity> list = this.repository.findByNameContains(name, pageable);
        return list;
    }

//    public List<IIdName> findByNameContainsMybatis(String name, Pageable pageable) {
//        List<FoodCategoryDto> list = this.mapper.findByNameContains(name, pageable);
//        List<IIdName> result = list.parallelStream()
//                .map(x -> (IIdName)x).toList();
//        return result;
//    }
}
