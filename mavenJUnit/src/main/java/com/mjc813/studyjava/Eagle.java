package com.mjc813.studyjava;

/**
 * Eagle 클래스는 Bird 상속
 * fly 메서드 재정의 - 높이 난다
 * eat 메서드 오버로딩 (Animal 타입만 처리)
 * reproduce 메서드 오버라이딩하여 Eagle 객체 리턴
 */
public class Eagle extends Bird {

    public Eagle(String name, int age) {
        super(name, age);
    }

    // fly 메서드 재정의 - 높이 난다
    @Override
    public void fly() {
        System.out.println(name + " " + wings + " 높이 난다.");
    }

    // Animal 타입만 받는 eat 메서드 오버로딩
    public void eat(Animal prey) {
        System.out.println(name + "은 " + prey.name + "를 먹는다.");
    }

    // String 매개변수 eat는 무시 (아무 동작 안함)
    public void eat(String food) {
        // 아무것도 하지 않음
    }

    @Override
    public Eagle reproduce(String newName) {
        return new Eagle(newName, 0);
    }
}
