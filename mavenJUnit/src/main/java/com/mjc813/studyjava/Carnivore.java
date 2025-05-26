package com.mjc813.studyjava;

/**
 * Carnivore 클래스는 Mammalia 상속
 * eat 메서드 오버로딩 (Herbivore 타입만 처리)
 * reproduce 메서드 오버라이딩하여 Carnivore 객체 리턴
 */
public class Carnivore extends Mammalia {

    public Carnivore(String name, int age) {
        super(name, age);
    }

    // Herbivore 타입만 처리하는 eat 메서드 오버로딩
    public void eat(Herbivore prey) {
        if (prey instanceof Herbivore) {
            System.out.println(this.getName() + "은 " + prey + "를 먹는다.");
        }
    }

    @Override
    public Carnivore reproduce(String newName) {
        return new Carnivore(newName, 0);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
