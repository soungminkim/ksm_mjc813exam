package com.mjc813.studyjava;

import lombok.Getter;
import lombok.Setter;

/**
 * Bird 클래스는 Animal 상속
 * 날개(wings) 멤버변수 추가
 * flap(), fly() 메서드 구현
 * reproduce 메서드 오버라이딩하여 Bird 객체 리턴
 */
@Getter
@Setter
public class Bird extends Animal {
    private String wings;

    public Bird(String name, int age, String wings) {
        super(name, age);
        this.wings = "날개";  // 기본값 설정
    }

    public void flap() {
        System.out.println(this.getName() + " " + this.wings + " 날개짓한다.");
    }

    public void fly() {
        System.out.println(this.getName() + " " + this.wings + " 난다.");
    }

    @Override
    public Animal reproduce(String newName) {
        return new Bird(newName, 0, this.getWings());
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
