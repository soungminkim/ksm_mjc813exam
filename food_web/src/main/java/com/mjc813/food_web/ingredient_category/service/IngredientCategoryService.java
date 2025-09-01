package com.mjc813.food_web.ingredient_category.service;

import com.mjc813.food_web.common.IIdName;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryDto;
import com.mjc813.food_web.ingredient_category.dto.IngredientCategoryEntity;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientCategoryService {
    @Autowired
    private IngredientCategoryMapper mapper;

    @Autowired
    private IngredientCategoryRepository repository;

    public IIdName insertRepository(IngredientCategoryDto dto) {
        IngredientCategoryEntity entity = new IngredientCategoryEntity();
        entity.copyMembersIdName(dto);
        IngredientCategoryEntity result = this.repository.save(entity);
        return result;
    }

    public IIdName insertMybatis(IngredientCategoryDto dto) {
        this.mapper.insert(dto);
        return dto;
    }

    public IIdName updateRepository(IngredientCategoryDto dto) {
        return this.insertRepository(dto);
    }

    public IIdName updateMybatis(IngredientCategoryDto dto) {
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
        Optional<IngredientCategoryEntity> find = this.repository.findById(id);
        if ( find.isPresent() ) {
            return find.get();
        } else {
            throw new NotFoundException(String.format("data cat not found [%d]", id));
        }
    }

    public IIdName findByIdMybatis(Long id) throws Exception {
        IngredientCategoryDto find = this.mapper.findById(id);
        if ( find != null ) {
            return find;
        } else {
            throw new NotFoundException(String.format("data cat not found [%d]", id));
        }
    }

    public List<IIdName> findAllRepository() {
        List<IngredientCategoryEntity> all = this.repository.findAllByOrderByIdDesc();
        List<IIdName> result = all.parallelStream()
                .map(x -> (IIdName)x).toList();
        return result;
    }

    public List<IIdName> findAllMybatis() {
        List<IngredientCategoryDto> all = this.mapper.findAll();
        List<IIdName> result = all.parallelStream()
                .map(x -> (IIdName)x).toList();
        return result;
    }

    public Page<IngredientCategoryEntity> findByNameContainsRepository(String name, Pageable pageable) {
        Page<IngredientCategoryEntity> page = this.repository.findByNameContains(name, pageable);
        return page;
    }
}
