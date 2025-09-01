package com.mjc813.food_web.ingredient.service;

import com.mjc813.food_web.ingredient.dto.IIngredient;
import com.mjc813.food_web.ingredient.dto.IngredientDto;
import com.mjc813.food_web.ingredient.dto.IngredientEntity;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    @Autowired
    private IngredientMapper mapper;

    @Autowired
    private IngredientRepository repository;

    public IIngredient insertRepository(IngredientDto dto) {
        IngredientEntity entity = new IngredientEntity();
        entity.copyMembersIngredient(dto);
        IngredientEntity result = this.repository.save(entity);
        return result;
    }

    public IIngredient insertMybatis(IngredientDto dto) {
        this.mapper.insert(dto);
        return dto;
    }

    public IIngredient updateRepository(IngredientDto dto) {
        return this.insertRepository(dto);
    }

    public IIngredient updateMybatis(IngredientDto dto) {
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

    public IIngredient findByIdRepository(Long id) throws Exception {
        Optional<IngredientEntity> find = this.repository.findById(id);
        if ( find.isPresent() ) {
            return find.get();
        } else {
            throw new NotFoundException(String.format("data cat not found [%d]", id));
        }
    }

    public IIngredient findByIdMybatis(Long id) throws Exception {
        IngredientDto find = this.mapper.findById(id);
        if ( find != null ) {
            return find;
        } else {
            throw new NotFoundException(String.format("data cat not found [%d]", id));
        }
    }

    public List<IIngredient> findAllRepository() {
        List<IngredientEntity> all = this.repository.findAllByOrderByIdDesc();
        List<IIngredient> result = all.parallelStream()
                .map(x -> (IIngredient)x).toList();
        return result;
    }

    public List<IIngredient> findAllMybatis() {
        List<IngredientDto> all = this.mapper.findAll();
        List<IIngredient> result = all.parallelStream()
                .map(x -> (IIngredient)x).toList();
        return result;
    }

    public Page<IIngredient> findBySearch(String name, Long ingredientCategoryId, Pageable pageable) {
        Long count = this.mapper.countBySearch(name, ingredientCategoryId);
        List<IngredientDto> list = this.mapper.findBySearch(name, ingredientCategoryId, pageable);
        List<IIngredient> result = list.parallelStream()
                .map(x -> (IIngredient)x).toList();
        return new PageImpl<>(result, pageable, count);
    }
}
