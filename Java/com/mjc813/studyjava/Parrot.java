package com.mjc813.studyjava;

/**
 * Parrot 클래스는 Bird 상속
 * fly 메서드 재정의
 * eat 메서드 오버로딩 (String 타입만 처리)
 * reproduce 메서드 오버라이딩하여 Parrot 객체 리턴
 */
public class Parrot extends Bird {

    public Parrot(String name, int age) {
        super(name, age);
    }

    // fly 메서드 재정의 - 조금만 난다
    @Override
    public void fly() {
        System.out.println(name + " " + wings + " 조금만 난다.");
    }

    // String 타입 매개변수 eat 메서드 오버로딩
    public void eat(String food) {
        System.out.println(name + "은 " + food + "를 먹는다.");
    }

    // Object 타입 eat는 무시하거나 부모 호출 가능
    @Override
    public void eat(Object feed) {
        // 부모 eat 호출하지 않거나 빈 구현 가능
        //super.eat(feed);
    }

    @Override
    public Parrot reproduce(String newName) {
        return new Parrot(newName, 0);
    }
}
