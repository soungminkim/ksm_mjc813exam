package com.mjc813.studyjava;

/**
 * Eagle 클래스는 Bird 상속
 * fly 메서드 재정의 - 높이 난다
 * eat 메서드 오버로딩 (Animal 타입만 처리)
 * reproduce 메서드 오버라이딩하여 Eagle 객체 리턴
 */
public class Eagle extends Bird {

    public Eagle(String name, int age, String wings) {
        super(name, age, wings);
    }

    // fly 메서드 재정의 - 높이 난다
    @Override
    public void fly() {
        System.out.println(super.getName() + " " + super.getWings() + " 높이 난다.");
    }

    // Animal 타입만 받는 eat 메서드 오버로딩
    public void eat(Object prey) {
        if (prey instanceof Animal) {
            super.eat(prey);
        }
    }

    @Override
    public Eagle reproduce(String newName) {
        return new Eagle(newName, 0, "앵무새날개");
    }
    @Override
    public String toString() {
        return this.getName();
    }

}
