package com.mjc813.studyjava;

/**
 * Herbivore 클래스는 Mammalia 상속
 * reproduce 메서드 오버라이딩하여 Herbivore 객체 리턴
 */
public class Herbivore extends Mammalia {

    public Herbivore(String name, int age) {
        super(name, age);
    }

    @Override
    public Herbivore reproduce(String newName) {
        return new Herbivore(newName, 0);
    }
}
