package com.mjc813.swimpool_app.swimpool.service;

import com.mjc813.swimpool_app.swimpool.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    @Autowired
    private IUserMybatis mybatisMapper;

    public UserDto insertUser(UserDto dto){
        // log.debug(dto.getAddr()); 해당식으로 로그를 풀어낼수도 있음
        dto.setRole("ROLE_USER");
        this.mybatisMapper.insertUser(dto);
        return dto;
    }
    public UserDto getOne(Long id){
        UserDto one = this.mybatisMapper.getOneUser(id);
        return one;
    }


    public List<UserDto> findAllUser(){
        List<UserDto> all = this.mybatisMapper.findaAllUser();
        return all;
    }
    public UserDto updateUser(UserDto dto){
        this.mybatisMapper.updateUser(dto);
        return dto;
    }
    public void deleteUser(Long id){
        this.mybatisMapper.deleteUser(id);
    }
    public Long countUsersBySearch(String search) {
        return mybatisMapper.countUsersBySearch(search);
    }
    public List<UserDto> findUsersBySearch(String search, int size, int offset) {
        return mybatisMapper.findUsersBySearch(search, size, offset);
    }
}
