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

    default void copyMembersFoodFile(IFoodFile isrc) {
        if ( isrc == null ) {
            return;
        }
        this.setId(isrc.getId());
        this.setName(isrc.getName());
        this.setSize(isrc.getSize());
        this.setExt(isrc.getExt());
        this.setRealName(isrc.getRealName());
        this.setDir(isrc.getDir());
        this.setFoodId(isrc.getFoodId());
    }

    default void copyMembersNotNullFoodFile(IFoodFile isrc) {
        if ( isrc == null ) {
            return;
        }
        if( isrc.getId() != null ) {
            this.setId(isrc.getId());
        }
        if( isrc.getName() != null && !isrc.getName().isEmpty() ) {
            this.setName(isrc.getName());
        }
        if( isrc.getSize() != null ) {
            this.setSize(isrc.getSize());
        }
        if( isrc.getExt() != null && !isrc.getExt().isEmpty() ) {
            this.setExt(isrc.getExt());
        }
        if( isrc.getRealName() != null && !isrc.getRealName().isEmpty() ) {
            this.setRealName(isrc.getRealName());
        }
        if( isrc.getDir() != null && !isrc.getDir().isEmpty() ) {
            this.setDir(isrc.getDir());
        }
        if( isrc.getFoodId() != null ) {
            this.setFoodId(isrc.getFoodId());
        }
    }
}
