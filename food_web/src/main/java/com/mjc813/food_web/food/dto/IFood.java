package com.mjc813.food_web.food.dto;

import com.mjc813.food_web.common.IIdName;

public interface IFood extends IIdName {
    Integer getSpicyLevel();
    void setSpicyLevel(Integer spicyLevel);

    Integer getSweetLevel();
    void setSweetLevel(Integer sweetLevel);

    Integer getSourLevel();
    void setSourLevel(Integer sourLevel);

    Integer getSaltyLevel();
    void setSaltyLevel(Integer saltyLevel);

    default void copyMembers(IFood from) {
        if (from == null) {
            return;
        }
        copyIdName(from);
        setSpicyLevel(from.getSpicyLevel());
        setSweetLevel(from.getSweetLevel());
        setSourLevel(from.getSourLevel());
        setSaltyLevel(from.getSaltyLevel());
    }
}