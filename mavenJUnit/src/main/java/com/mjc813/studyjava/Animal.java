package com.mjc813.studyjava;

import lombok.Getter;
import lombok.Setter;

/**
 * Animal 클래스
 * 기본 동물 클래스, 이름과 나이 멤버변수 포함
 * eat(Object), sleep(), move(), reproduce(String) 메서드 포함
 */

@Getter
@Setter
public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Object 타입 매개변수를 받아서 먹는다 출력
    public void eat(Object feed) {
        System.out.println(this.name + "은 " + feed + "를 먹는다.");
    }

    public void sleep() {
        System.out.println(this.name+ " 잔다");
    }

    public void move() {
        System.out.println(this.name + " 이동한다");
    }

    // Animal 객체를 새로 생성하여 리턴 (재생산)
    public Animal reproduce(String newName) {
        return new Animal(newName, 0);
    }
}
