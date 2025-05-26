package com.mjc813.studyjava;

/**
 * Parrot 클래스는 Bird 상속
 * fly 메서드 재정의
 * eat 메서드 오버로딩 (String 타입만 처리)
 * reproduce 메서드 오버라이딩하여 Parrot 객체 리턴
 */
public class Parrot extends Bird {

    public Parrot(String name, int age, String wings) {
        super(name, age, wings);
    }

    // fly 메서드 재정의 - 조금만 난다
    @Override
    public void fly() {
        System.out.println(super.getName() + " " + super.getWings() + " 조금만 난다.");
    }

    // String 타입 매개변수 eat 메서드 오버로딩
    public void eat(String food) {
        if (food instanceof String) {
            super.eat(food);
        }
    }

    @Override
    public Parrot reproduce(String newName) {
        return new Parrot(newName, 0, "앵무새날개");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
