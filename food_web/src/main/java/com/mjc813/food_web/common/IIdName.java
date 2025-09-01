package com.mjc813.food_web.common;

public interface IIdName {
    Long getId();
    void setId(Long id);

    String getName();
    void setName(String id);

    default void copyMembersIdName(IIdName iIdName) {
        if ( iIdName == null ) {  // 매개변수의 객체가 null 이면 복사 중지
            return;
        }
        this.setId(iIdName.getId());
        this.setName(iIdName.getName());
    }

    default void copyMembersIdNameNotNull(IIdName iIdName) {
        if ( iIdName == null ) {  // 매개변수의 객체가 null 이면 복사 중지
            return;
        }
        if (iIdName.getId() != null) {  // 매개변수의 객체의 멤버변수 id가 null 이면 복사 중지
            this.setId(iIdName.getId());
        }
        if (iIdName.getName() != null) {  // 매개변수의 객체의 멤버변수 name이 null 이면 복사 중지
            this.setName(iIdName.getName());
        }
    }
}
