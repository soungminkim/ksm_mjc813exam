package com.mjc813.cinema_crud.common;

public enum ResponseEnum {
    Success(0),
    SelectFail(40),
    InsertFail(50),
    UpdateFail(60),
    DeleteFail(70);

    private final Integer code;
    ResponseEnum(Integer code) {
        this.code = code;
    }
    public Integer getCode() {
        return this.code;
    }
}
