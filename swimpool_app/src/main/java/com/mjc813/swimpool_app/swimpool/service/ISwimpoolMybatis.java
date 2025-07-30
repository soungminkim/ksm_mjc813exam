package com.mjc813.swimpool_app.swimpool.service;

import com.mjc813.swimpool_app.swimpool.dto.SwimpoolDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ISwimpoolMybatis {
    public void insert(SwimpoolDto dto);
    public List<SwimpoolDto> findAll();
    public SwimpoolDto getOne(Integer id);
    public void update(SwimpoolDto dto);
    public void delete(Integer id);
    public List<SwimpoolDto> findBySearch(String search);
    public Long countBySearch(@Param("search") String search);
    List<SwimpoolDto> findBySearch(@Param("search") String search,
                                   @Param("size") int size,
                                   @Param("offset") int offset);

}
