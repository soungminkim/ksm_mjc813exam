package com.mjc813.coffee.service;

import com.mjc813.coffee.dto.CoffeeDto;
import com.mjc813.coffee.dto.SearchRequestDto;
import com.mjc813.coffee.mybatis.CoffeeMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    @Autowired //mapper is-a 관계 여야 하기에 사용됌
    private CoffeeMybatis coffeeMybatis;

    public void insert(CoffeeDto coffeeDto) {
        this.coffeeMybatis.insert(coffeeDto);
    }
    public List<CoffeeDto> selectAll() {
        List<CoffeeDto> all = this.coffeeMybatis.selectAll();
        return all;
    }

    public CoffeeDto selectById(Long id) {
        return this.coffeeMybatis.selectById(id);
    }

    public void update(CoffeeDto coffeeDto) {
        this.coffeeMybatis.update(coffeeDto);
    }

    public void deleteById(Long id) {
        this.coffeeMybatis.deleteById(id);
    }

    public List<CoffeeDto> findWhere(SearchRequestDto serch) {
        List<CoffeeDto> where = this.coffeeMybatis.findWhere(serch);
        return where;

    }
}
