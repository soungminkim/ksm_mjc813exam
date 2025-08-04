package com.mjc813.food_web.food.dto;

public interface IFood {
    public Long getId();
    public String getName();
    public Integer getSpicyLevel();
    public Integer getSweetLevel();
    public Integer getSourLevel();
    public Integer getSaltyLevel();

    public void setId(final Long id);
    public void setName(final String name);
    public void setSpicyLevel(final Integer spicyLevel);
    public void setSweetLevel(final Integer sweetLevel);
    public void setSourLevel(final Integer sourLevel);
    public void setSaltyLevel(final Integer saltyLevel);

    default void copyMembers(IFood from) {
        setId(from.getId());
        setName(from.getName());
        setSpicyLevel(from.getSpicyLevel());
        setSweetLevel(from.getSweetLevel());
        setSourLevel(from.getSourLevel());
        setSaltyLevel(from.getSaltyLevel());
    }
}
