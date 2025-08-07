package com.mjc813.food_web.common;

public interface IIdName {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String name);

    default void copyIdName(IIdName source) {
        if (source == null) {
            return;
        }
        this.setId(source.getId());
        this.setName(source.getName());
    }

    default void copyIdNameNotNull(IIdName source) {
        if (source == null) {
            return;
        }
        if (source.getId() != null) {
            this.setId(source.getId());
        }
        if (source.getName() != null) {
            this.setName(source.getName());
        }
    }
}