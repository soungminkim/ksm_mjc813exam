package com.mjc813.studyjava;

/**
 * Mammalia 클래스는 Animal 상속
 * feedingMilk() 메서드 추가
 * eat 메서드 오버로딩 (String 타입만 처리)
 * reproduce 메서드 오버라이딩하여 Mammalia 객체 리턴
 */
public class Mammalia extends Animal {

    public Mammalia(String name, int age) {
        super(name, age);
    }

    public void feedingMilk() {
        System.out.println(name + " 젖을 먹인다.");
    }

    // String 타입만 처리하는 eat 메서드 오버로딩
    public void eat(String food) {
        System.out.println(name + "은 " + food + "를 먹는다.");
    }

    // Object 타입 eat는 무시하거나 빈 구현 가능
    @Override
    public void eat(Object feed) {
        // 무시하거나 부모 호출 안 함
    }

    @Override
    public Mammalia reproduce(String newName) {
        return new Mammalia(newName, 0);
    }
}
