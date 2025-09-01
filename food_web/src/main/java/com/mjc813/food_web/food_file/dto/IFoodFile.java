package com.mjc813.food_web.food_file.dto;

import com.mjc813.food_web.food.dto.IFood;

public interface IFoodFile {
    Long getId();;
    String getName();
    Long getSize();
    String getExt();
    String getRealName();
    String getDir();
    Long getFoodId();
    IFood getFood();

    void setId(final Long id);
    void setName(final String name);
    void setSize(final Long size);
    void setExt(final String ext);
    void setRealName(final String realName);
    void setDir(final String dir);
    void setFoodId(final Long foodId);
    void setFood(final IFood food);
}
