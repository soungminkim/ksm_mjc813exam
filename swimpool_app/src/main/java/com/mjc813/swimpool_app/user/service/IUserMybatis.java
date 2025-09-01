package com.mjc813.swimpool_app.user.service;

import com.mjc813.swimpool_app.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserMybatis {
    public void insertUser(UserDto user); // 회원가입
    public List<UserDto> findaAllUser();
    public UserDto getOneUser(Long id);
    public UserDto findById(Long id);
    public void updateUser(UserDto user); // 회원 정보 수정
    public void deleteUser(Long id); // 회원 삭제
    public Long countUsersBySearch(@Param("search") String search);
    List<UserDto> findUsersBySearch(@Param("search") String search,
                                   @Param("size") int size,
                                   @Param("offset") int offset);
}