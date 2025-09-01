package com.mjc813.swimpool_app.security.service;

import com.mjc813.swimpool_app.common.ResponseDto;
import com.mjc813.swimpool_app.common.ResponseEnum;
import com.mjc813.swimpool_app.security.dto.LoginDto;
import com.mjc813.swimpool_app.user.dto.UserDto;
import com.mjc813.swimpool_app.user.service.IUserMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private IUserMybatis userMapper;

    public ResponseDto cookieLogin(LoginDto loginDto) {
        if ( loginDto == null ) {
            return ResponseDto.builder().code(ResponseEnum.LoginFail.getCode()).responseEnum(ResponseEnum.LoginFail).build();
        }
        UserDto find = this.userMapper.findByUsername(loginDto);
        if ( find == null ) {
            return ResponseDto.builder().code(ResponseEnum.LoginFail.getCode()).responseEnum(ResponseEnum.LoginFail).build();
        }
        if ( !loginDto.getPassword().equals(find.getPassword()) ) {
            return ResponseDto.builder().code(ResponseEnum.LoginFail.getCode()).responseEnum(ResponseEnum.LoginFail).build();
        }
        return ResponseDto.builder().code(ResponseEnum.Success.getCode()).responseEnum(ResponseEnum.Success).build();
    }
}