package com.mjc813.coffee.mybatis;

import com.mjc813.coffee.dto.CoffeeDto;
import com.mjc813.coffee.dto.SearchRequestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoffeeMybatis {
    public void insert(CoffeeDto coffeeDto);
    public List<CoffeeDto> selectAll();
    public CoffeeDto selectById(Long id);
    public void update(CoffeeDto coffeeDto);
    public void deleteById(Long id);
    public List<CoffeeDto> findWhere(SearchRequestDto search);
    public Long countall();
    public Long countBySearch(SearchRequestDto search);
}
