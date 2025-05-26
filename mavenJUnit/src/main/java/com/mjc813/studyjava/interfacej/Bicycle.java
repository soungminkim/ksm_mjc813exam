package com.mjc813.studyjava.interfacej;

import lombok.Getter;
import lombok.Setter;
//멤버변수 : String name, int wheelCount;
//생성자 : 필요하다
//멤버메소드 : String move();	=> "{wheelCount}개의 바퀴의 자전거{이름}을 이동한다." 문자열 리턴
//String breakk();	=> "자전거{이름}을 정지한다." 문자열 리턴
@Getter
@Setter
public class Bicycle implements IBicycle {
    private String name;
    private int wheelCount;

    public Bicycle(String name, int wheelCount) {
        this.name = name;
        this.wheelCount = wheelCount;
    }

    public String drive() {
        return (wheelCount + "개의 바퀴의 자전거" + name + "을 이동한다.");
    }
    public String breakk(){
        return ("자전거" + name + "을 정지한다.");
    }
}
