package com.mjc813.swimpool_app.swimpool.service;

import com.mjc813.swimpool_app.swimpool.dto.SwimpoolDto;
import com.mjc813.swimpool_app.swimpool.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IUserMybatis {
    public void insertUser(UserDto user); // 회원가입
    public List<UserDto> findallUser();
    public UserDto getOneUser(Long id);
    public void updateUser(UserDto user); // 회원 정보 수정
    public void deleteUser(Long id); // 회원 삭제
    public Long countUsersBySearch(@Param("search") String search);
    List<UserDto> findUsersBySearch(@Param("search") String search,
                                   @Param("size") int size,
                                   @Param("offset") int offset);
}