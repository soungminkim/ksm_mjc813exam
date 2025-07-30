package com.mjc813.cinema_crud.common;

public enum ResponseEnum {
    Success(0),
    CinemaSelectFail(10),
    GenreSelectFail(100),
    CinemaInsertFail(20),
    GenreInsertFail(200),
    CinemaUpdateFail(30),
    GenreUpdateFail(300),
    CinemaDeleteFail(70),
    GenreDeleteFail(700);

    private final Integer code;
    ResponseEnum(Integer code) {
        this.code = code;
    }
    public Integer getCode() {
        return this.code;
    }
}
